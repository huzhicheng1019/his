package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.PdDao;
import cn.gson.his.model.dao.Drug.PdxqDao;
import cn.gson.his.model.mappers.Drug.CangkMapper;
import cn.gson.his.model.mappers.Drug.PdMapper;
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
public class PdService {
    @Autowired
    CangkMapper cangkMapper;

    @Autowired
    PdDao pdDao;

    @Autowired
    PdxqDao pdxqDao;

    @Autowired
    PdMapper pdMapper;

    public Map<String,Object> ckpdcx(Integer id, Integer lx){
        System.out.println(id);
        Map<String,Object> map = new HashMap<>();
        List<LibraryxqEntity> ckxqcx = new ArrayList<>();
        if(lx==0 || lx==1){
            ckxqcx=cangkMapper.ckxqcx(id, "");
        }else if(lx==2){
            ckxqcx=cangkMapper.ckgqcx(id);
        }else{
            ckxqcx=cangkMapper.cklqcx(id);
        }
        map.put("rows",ckxqcx);
        return map;
    }

    public void xzPd(ChecksEntity checksEntity, List<Checkxq> checkxqList){
        System.out.println("one");
        pdDao.save(checksEntity);
        for (Checkxq checkxq : checkxqList) {
            checkxq.setCheckId(checksEntity.getCheckId());
            pdxqDao.save(checkxq);
        }
        System.out.println("three");
    }

    public Map<String,Object> pdselect(int pageNo, int size, String nr){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",pdMapper.pdcx(nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> pdxqselect(int pageNo, int size,String id, String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",pdMapper.pdxqcx(id, nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> shpdxqcx(String id){
        System.out.println(id);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",pdMapper.pdxqcx(id, ""));
        return map;
    }
}
