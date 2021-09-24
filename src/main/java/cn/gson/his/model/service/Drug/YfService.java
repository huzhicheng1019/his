package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.*;
import cn.gson.his.model.mappers.Drug.CangkMapper;
import cn.gson.his.model.mappers.Drug.TyMapper;
import cn.gson.his.model.mappers.Drug.YfMapper;
import cn.gson.his.model.pojos.Drug.*;
import cn.gson.his.model.pojos.Outpatient.PrescriptionEntity;
import cn.gson.his.model.pojos.Outpatient.PrescriptionsEntity;
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
public class YfService {
    @Autowired
    YfMapper yfMapper;

    @Autowired
    CangkMapper cangkMapper;

    @Autowired
    FyDao fyDao;

    @Autowired
    FyxqDao fyxqDao;

    @Autowired
    ChukDao chukDao;

    @Autowired
    ChukjlDao chukjlDao;

    @Autowired
    CankxqDao cankxqDao;

    @Autowired
    TyMapper tyMapper;

    public Map<String,Object> yfselect(int pageNo, int size, String nr){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",yfMapper.yfcx(nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> yfxqselect(int pageNo, int size,String id, String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",yfMapper.yfxqcx(id, nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> yfckselect(){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        map.put("yfck",cangkMapper.yfckcx());
        return map;
    }

    public Map<String,Object> yfcfxq(Integer id,Integer pid,String fl){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        map.put("yfcfxq",cangkMapper.yfcfcx(id, pid, fl));
        return map;
    }

    public Map<String,Object> cfxq(Integer id){
        PrescriptionEntity cfidcx = yfMapper.cfidcx(id);
        System.out.println(cfidcx);
        String pd="bcz";
        if(cfidcx==null){
            pd="bcz";
        }else {
            if(cfidcx.getPriveType().equals("1")){
                pd="ok";
            }else if(cfidcx.getPriveType().equals("0")){
                pd="no";
            }
        }

        Map<String,Object> map = new HashMap<>();
        //分页查询
        map.put("cfxq",yfMapper.cfxqcx(id));
        map.put("pd",pd);
        return map;
    }

    public void xzfy(PillsEntity pillsEntity, List<Pillsxq> pillsxqList){
        System.out.println("one");
        Timestamp d = new Timestamp(System.currentTimeMillis());
        pillsEntity.setPillsDate(d);
        ChuEntity chuEntity = new ChuEntity(pillsEntity.getPillsDate(),pillsEntity.getLibrary(),pillsEntity.getEmployee(),3,pillsEntity.getPillsId());
        List<ChujlEntity> chujlEntityList=new ArrayList<>();
        fyDao.save(pillsEntity);
        chukDao.save(chuEntity);
        for (Pillsxq pillsxq : pillsxqList) {
            pillsxq.setPillsId(pillsEntity.getPillsId());
            ChujlEntity chujlEntity = new ChujlEntity(pillsxq.getProductId(),pillsxq.getProductName(),pillsxq.getProductFl(),pillsxq.getSl(),pillsxq.getPh(),chuEntity.getChuId(),pillsxq.getDrugGe(),pillsxq.getGys(),pillsxq.getScdate(),pillsxq.getGqdate(),pillsxq.getPrice(),pillsxq.getKszt(),pillsxq.getGesl(),pillsxq.getShdw());
            chujlEntityList.add(chujlEntity);
            fyxqDao.save(pillsxq);
        }
        List<LibraryxqEntity> ckxqcx = cangkMapper.ckxqcx(pillsEntity.getLibrary().getLibraryId(), "");

        for (ChujlEntity chujlEntity : chujlEntityList) {
            for (LibraryxqEntity libraryxqEntity : ckxqcx) {
                if(chujlEntity.getProductId()==libraryxqEntity.getProductId() && chujlEntity.getProductFl().equals(libraryxqEntity.getProductFl()) &&
                        chujlEntity.getPh().equals(libraryxqEntity.getPh())){
                    libraryxqEntity.setKcs(libraryxqEntity.getKcs()-chujlEntity.getSl());
                }
            }
            chukjlDao.save(chujlEntity);
        }
        for (LibraryxqEntity libraryxqEntity : ckxqcx) {
            cankxqDao.save(libraryxqEntity);
        }
    }

    public void bj(PillsEntity pillsEntity){
        fyDao.save(pillsEntity);
    }




    public Map<String,Object> yfidselect(String nr){
        Map<String,Object> map = new HashMap<>();
        map.put("rows",yfMapper.yfcx(nr));
        return map;
    }

    public Map<String,Object> yfxqidcx(String id,String nr){
        List<Pillsxq> pillsxqList=yfMapper.yfxqcx(id,nr);
        List<RefundEntity> refundEntityList=tyMapper.tycxid(id);
        List<Refundxq> refundxqs=null;

        for (RefundEntity refundEntity : refundEntityList) {
            List<Refundxq> tyxqcx = tyMapper.tyxqcx(refundEntity.getRefundId(),"");
            for (Refundxq refundxq : tyxqcx) {
                refundxqs.add(refundxq);
            }
        }

        if(pillsxqList!=null){
            for (int i=0;i<pillsxqList.size();i++) {
                if(refundxqs!=null){
                    for(int j=0;j<refundxqs.size();j++){
                        if(pillsxqList.get(i).getProductId().equals(refundxqs.get(j).getProductId()) && pillsxqList.get(i).getProductFl().equals(refundxqs.get(j).getProductFl()) &&
                                pillsxqList.get(i).getPh().equals(refundxqs.get(j).getPh())){
                            pillsxqList.get(i).setSl(pillsxqList.get(i).getSl()-refundxqs.get(j).getSl());
                        }
                        if(pillsxqList.get(i).getSl()<=0){
                            pillsxqList.remove(pillsxqList.get(i));
                            i--;
                        }
                    }
                }
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("rows",pillsxqList);
        return map;
    }
}