package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.CangkDao;
import cn.gson.his.model.dao.Drug.CankxqDao;
import cn.gson.his.model.mappers.Drug.CangkMapper;
import cn.gson.his.model.mappers.Drug.ConMapper;
import cn.gson.his.model.mappers.Drug.YpMapper;
import cn.gson.his.model.pojos.Drug.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CangkService {
    @Autowired
    CangkMapper cangkMapper;

    @Autowired
    YpMapper ypMapper;

    @Autowired
    ConMapper conMapper;

    @Autowired
    CangkDao cangkDao;

    @Autowired
    CankxqDao cankxqDao;

    public Map<String,Object> ckselect(int pageNo, int size, String nr){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",cangkMapper.cangkcx(nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> ckxqselect(int pageNo, int size,Integer id, String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",cangkMapper.ckxqcx(id,nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> ckxxselect(Integer id, String nr){
        Map<String,Object> map = new HashMap<>();
        List<LibraryxqEntity> ckxqcx = cangkMapper.ckxqcx(id, nr);
        System.out.println("这里：");
        for (LibraryxqEntity libraryxqEntity : ckxqcx) {
            System.out.println(libraryxqEntity);
        }
        map.put("ck",cangkMapper.ckcxid(id).get(0));
        map.put("ckxq",ckxqcx);
        return map;
    }

    public Map<String,Object> ypselect(DrugEntity drugEntity){
        Map<String,Object> map = new HashMap<>();
        map.put("rows",ypMapper.selectyp(drugEntity));
        return map;
    }

    public Map<String,Object> conselect(ConEntity conEntity){
        Map<String,Object> map = new HashMap<>();
        map.put("rows",conMapper.concx(conEntity));
        return map;
    }

    public int stojlcx(LibraryxqEntity libraryxqEntity){
        System.out.println(libraryxqEntity.getLibrary().getLibraryId());
        List<StoEntity> stocx = cangkMapper.stocx(libraryxqEntity.getLibrary().getLibraryId());
        int size=0;
        for (StoEntity sto: stocx) {
            List<StojlEntity> stojlcx= cangkMapper.stojlcx(sto.getStoId(), libraryxqEntity.getProductId(), libraryxqEntity.getProductFl(), libraryxqEntity.getPh());
            size=size+stojlcx.size();
        }
        return size;
    }

    public int chujlcx(LibraryxqEntity libraryxqEntity){
        List<ChuEntity> chucx = cangkMapper.chucx(libraryxqEntity.getLibrary().getLibraryId());
        int size=0;
        for (ChuEntity chuEntity : chucx) {
            List<ChujlEntity> chujlcx = cangkMapper.chujlcx(chucx.get(0).getChuId(), libraryxqEntity.getProductId(), libraryxqEntity.getProductFl(), libraryxqEntity.getPh());
            size=size+chujlcx.size();
        }
        return size;
    }

    public void xzgxck(LibraryInfoEntity libraryInfo,List<LibraryxqEntity> libraryxqList,List<LibraryxqEntity> delxq){

        for (LibraryxqEntity libraryxqEntity : delxq) {
            cankxqDao.deleteById(libraryxqEntity.getLibraryxqId());
        }

        LibraryInfoEntity librarysave = cangkDao.save(libraryInfo);

        System.out.println(librarysave.getLibraryId());

        for (LibraryxqEntity libraryxqEntity : libraryxqList) {
            Calendar c=Calendar.getInstance();
            c.setTimeInMillis(libraryxqEntity.getScdate().getTime());
            if(libraryxqEntity.getProductFl().equals("0")){
                DrugEntity ypcxid = ypMapper.ypcxid(libraryxqEntity.getProductId());
                c.add(Calendar.MONTH,ypcxid.getBzq());
            }else if (libraryxqEntity.getProductFl().equals("1")){
                ConEntity concxid = conMapper.concxid(libraryxqEntity.getProductId());
                c.add(Calendar.MONTH,concxid.getBzq());
            }
            Timestamp timestamp = new Timestamp(c.getTimeInMillis());
            libraryxqEntity.setGqdate(timestamp);
            libraryxqEntity.setLibrary(librarysave);
            cankxqDao.save(libraryxqEntity);
        }
    }

    public String xzxgpd(int id,String name){
        String pd="ok";
        List<LibraryInfoEntity> cangkcx = cangkMapper.cangkcx("");
        if(id!=-1){
            for (LibraryInfoEntity libraryInfoEntity : cangkcx) {
                if (libraryInfoEntity.getLibraryId()!=id && libraryInfoEntity.getLibraryName().equals(name)) {
                    pd="no";
                }
            }
        }else{
            for (LibraryInfoEntity libraryInfoEntity : cangkcx) {
                if (libraryInfoEntity.getLibraryName().equals(name)) {
                    pd="no";
                }
            }
        }

        return pd;
    }

    public String delck(Integer id){
        List<StoEntity> stocx = cangkMapper.stocx(id);
        List<ChuEntity> chucx = cangkMapper.chucx(id);

        if(stocx.size()>0 || chucx.size()>0){
            return "不可删除";
        }else {
            List<LibraryxqEntity> ckxqcx = cangkMapper.ckxqcx(id, "");
            for (LibraryxqEntity libraryxqEntity : ckxqcx) {
                cankxqDao.deleteById(libraryxqEntity.getLibraryxqId());
            }
            cangkDao.deleteById(id);
            return "ok";
        }
    }
}
