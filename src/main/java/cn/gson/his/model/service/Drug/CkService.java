package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.CankxqDao;
import cn.gson.his.model.dao.Drug.ChukDao;
import cn.gson.his.model.dao.Drug.ChukjlDao;
import cn.gson.his.model.mappers.Drug.CangkMapper;
import cn.gson.his.model.mappers.Drug.CgthMapper;
import cn.gson.his.model.mappers.Drug.CkMapper;
import cn.gson.his.model.pojos.Drug.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CkService {
    @Autowired
    CkMapper ckMapper;

    @Autowired
    CgthMapper cgthMapper;

    @Autowired
    CangkMapper cangkMapper;

    @Autowired
    ChukDao chukDao;

    @Autowired
    ChukjlDao chukjlDao;

    @Autowired
    CankxqDao cankxqDao;

    public Map<String, Object> chucx(int pageNo, int size, String why, String nr){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",ckMapper.chucx(why,nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String, Object> chuxqcx(int pageNo, int size,Integer id, String nr){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",ckMapper.chujlcx(id,nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> cgthcx(String nr){
        Map<String,Object> map = new HashMap<>();
        map.put("cgth",cgthMapper.cgthcx(nr));
        return map;
    }

    public Map<String,Object> cgthxqcx(String id,Integer libraryId){
        //要显示的集合
        List<OrderthxqEntity> thxq=new ArrayList<>();
        //退货详情
        List<OrderthxqEntity> cgthxqcx = cgthMapper.cgthxqcx(id,"");
        //该退货单已出库的集合
        List<ChujlEntity> chujllyid = ckMapper.chujllyid(id);
        for (int i=0;i<cgthxqcx.size();i++) {
            for (int j=0;j<chujllyid.size();j++) {
                if(chujllyid.get(j)!=null){
                    if(cgthxqcx.get(i).getProductId().equals(chujllyid.get(j).getProductId()) && cgthxqcx.get(i).getProductFl().equals(chujllyid.get(j).getProductFl()) &&
                            cgthxqcx.get(i).getPh().equals(chujllyid.get(j).getPh())){
                        cgthxqcx.get(i).setSl(cgthxqcx.get(i).getSl()-chujllyid.get(j).getSl());
                    }
                    if (cgthxqcx.get(i).getSl()<=0){
                        cgthxqcx.remove(cgthxqcx.get(i));
                        i--;
                    }
                }

            }
        }
        //该仓库的数据
        List<LibraryxqEntity> ckxqcx = cangkMapper.ckxqcx(libraryId, "");
        for (OrderthxqEntity orderthxqEntity : cgthxqcx) {
            System.out.println(orderthxqEntity.getProductId());
            for (LibraryxqEntity libraryxqEntity : ckxqcx) {
                if(orderthxqEntity.getProductId().equals(libraryxqEntity.getProductId()) && orderthxqEntity.getProductFl().equals(libraryxqEntity.getProductFl()) &&
                        orderthxqEntity.getPh().equals(libraryxqEntity.getPh())){
                    System.out.println(1);
                    if(orderthxqEntity.getSl()>libraryxqEntity.getKcs()){
                        orderthxqEntity.setSl(libraryxqEntity.getKcs());
                        System.out.println("2");
                    }
                    if(orderthxqEntity.getSl()>0){
                        System.out.println("3");
                        thxq.add(orderthxqEntity);
                    }
                }
            }
        }
        System.out.println("大小："+thxq.size());
        Map<String,Object> map = new HashMap<>();
        map.put("cgthxq",thxq);
        return map;
    }

    public void xzchu(ChuEntity chuEntity, List<ChujlEntity> chujlEntityList){
        chukDao.save(chuEntity);
        for (ChujlEntity chujlEntity : chujlEntityList) {
            chujlEntity.setChuId(chuEntity.getChuId());
            chukjlDao.save(chujlEntity);
        }

        List<LibraryxqEntity> ckxqcx = cangkMapper.ckxqcx(chuEntity.getLibrary().getLibraryId(), "");

        for (LibraryxqEntity libraryxqEntity : ckxqcx) {
            for (ChujlEntity chujlEntity : chujlEntityList) {
                if(chujlEntity.getProductId()==libraryxqEntity.getProductId() && chujlEntity.getProductFl().equals(libraryxqEntity.getProductFl()) &&
                        chujlEntity.getPh().equals(libraryxqEntity.getPh())){
                    System.out.println(1333);
                    System.out.println(chujlEntity);
                    libraryxqEntity.setKcs(libraryxqEntity.getKcs()-chujlEntity.getSl());
                    cankxqDao.save(libraryxqEntity);
                }
            }
        }

    }
}
