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
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",cangkMapper.ckxqcx(id,nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> ckxxselect(Integer id, String nr){
        Map<String,Object> map = new HashMap<>();
        map.put("ck",cangkMapper.ckcxid(id).get(0));
        map.put("ckxq",cangkMapper.ckxqcx(id,nr));
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
        System.out.println(libraryxqEntity.getLibraryId());
        List<StoEntity> stocx = cangkMapper.stocx(libraryxqEntity.getLibraryId());
        int size=0;
        for (StoEntity sto: stocx) {
            List<StojlEntity> stojlcx= cangkMapper.stojlcx(sto.getStoId(), libraryxqEntity.getProductId(), libraryxqEntity.getProductFl(), libraryxqEntity.getPh());
            size=size+stojlcx.size();
        }
        return size;
    }

    public int chujlcx(LibraryxqEntity libraryxqEntity){
        List<ChuEntity> chucx = cangkMapper.chucx(libraryxqEntity.getLibraryId());
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
            libraryxqEntity.setLibraryId(librarysave.getLibraryId());
            cankxqDao.save(libraryxqEntity);
        }
    }
}
