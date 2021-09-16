package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.*;
import cn.gson.his.model.mappers.Drug.CangkMapper;
import cn.gson.his.model.mappers.Drug.ConMapper;
import cn.gson.his.model.mappers.Drug.TyMapper;
import cn.gson.his.model.mappers.Drug.YpMapper;
import cn.gson.his.model.pojos.Drug.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TyService {
    @Autowired
    TyMapper tyMapper;

    @Autowired
    TyDao tyDao;

    @Autowired
    TyxqDao tyxqDao;

    @Autowired
    RkDao rkDao;

    @Autowired
    RkxqDao rkxqDao;

    @Autowired
    CangkMapper cangkMapper;

    @Autowired
    CankxqDao cankxqDao;

    @Autowired
    YpMapper ypMapper;

    @Autowired
    ConMapper conMapper;

    public Map<String,Object> tyselect(int pageNo, int size, String nr){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",tyMapper.tycx(nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> tyxqselect(int pageNo, int size,String id, String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",tyMapper.tyxqcx(id,nr));
        map.put("total",page.getTotal());
        return map;
    }

    public void tyxz(RefundEntity refundEntity, List<Refundxq> refundxqList){
        Timestamp d = new Timestamp(System.currentTimeMillis());

        refundEntity.setRefundDate(d);
        StoEntity stoEntity = new StoEntity(refundEntity.getRefundDate(),refundEntity.getLibrary(),2, refundEntity.getEmployee(),refundEntity.getRefundId());
        List<StojlEntity> stojlEntityList=new ArrayList<>();
        tyDao.save(refundEntity);
        rkDao.save(stoEntity);
        for (Refundxq refundxq : refundxqList) {
            refundxq.setRefundId(refundEntity.getRefundId());
            StojlEntity stojlEntity = new StojlEntity(stoEntity,refundxq.getProductName(),refundxq.getProductId(),refundxq.getProductFl(),refundxq.getSl(),refundxq.getPh(),refundxq.getBz(),refundxq.getDrugGe(),refundxq.getGys(),refundxq.getPrice(),refundxq.getScdate(),refundxq.getGqdate(),refundxq.getKszt(),refundxq.getGesl(),refundxq.getShdw());
            stojlEntityList.add(stojlEntity);
            tyxqDao.save(refundxq);
        }
        List<LibraryxqEntity> ckxqcx = cangkMapper.ckxqcx(refundEntity.getLibrary().getLibraryId(), "");
        int a=0;
        for (StojlEntity stojlEntity : stojlEntityList) {
            for (LibraryxqEntity libraryxqEntity : ckxqcx) {
                if(stojlEntity.getProductId()==libraryxqEntity.getProductId() && stojlEntity.getProductFl().equals(libraryxqEntity.getProductFl()) &&
                        stojlEntity.getPh().equals(libraryxqEntity.getPh())){
                    libraryxqEntity.setKcs(libraryxqEntity.getKcs()+stojlEntity.getSl());
                    a=1;
                }
            }
            if(a==0){
                long sjprice=0l;
                if(stojlEntity.getProductFl().equals("0")){
                    DrugEntity ypcxid = ypMapper.ypcxid(stojlEntity.getProductId());
                    sjprice=ypcxid.getDrugPrice();
                }else{
                    ConEntity concxid = conMapper.concxid(stojlEntity.getProductId());
                    sjprice=concxid.getConPrice();
                }
                LibraryxqEntity libraryxqEntity=new LibraryxqEntity(stojlEntity.getProductId(),stojlEntity.getProductName(),stojlEntity.getProductFl(),stojlEntity.getSl(),stojlEntity.getPh(),stojlEntity.getScdate(),stojlEntity.getGqdate(),stoEntity.getLibrary(),stojlEntity.getPrice()
                ,stojlEntity.getGe(),stojlEntity.getSl(),stojlEntity.getGys(),sjprice,stojlEntity.getKszt(),stojlEntity.getGesl(),stojlEntity.getShdw());
                ckxqcx.add(libraryxqEntity);
                sjprice=0l;
            }
            rkxqDao.save(stojlEntity);
            a=0;
        }
        for (LibraryxqEntity libraryxqEntity : ckxqcx) {
            cankxqDao.save(libraryxqEntity);
        }
    }

}
