package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.DbDao;
import cn.gson.his.model.dao.Drug.DbxqDao;
import cn.gson.his.model.mappers.Drug.CangkMapper;
import cn.gson.his.model.mappers.Drug.DbsqMapper;
import cn.gson.his.model.pojos.Drug.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DbsqService {
    @Autowired
    DbsqMapper dbsqMapper;
    @Autowired
    CangkMapper cangkMapper;
    @Autowired
    DbDao dbDao;
    @Autowired
    DbxqDao dbxqDao;

    public Map<String,Object> dbselect(int pageNo, int size, String nr){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",dbsqMapper.dbcx(nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> dbxqselect(int pageNo, int size,Integer id, String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",dbsqMapper.dbxqcx(id, nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> dbckxqcx(Integer id, String nr,Integer ckid){
        System.out.println(id);
        System.out.println(nr);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",cangkMapper.dbckxqcx(id,nr,ckid));
        return map;
    }

    public void xzxgdb(Allot allot, List<Allotxq> allotxqList, List<Allotxq> delxq){
        for (Allotxq allotxq : delxq) {
            dbxqDao.deleteById(allotxq.getAllotxqId());
        }
        dbDao.save(allot);
        for (Allotxq allotxq : allotxqList) {
            allotxq.setAllotId(allot.getAllotId());
            dbxqDao.save(allotxq);
        }
    }

    public Map<String,Object> dbcxid(Integer id){
        Map<String,Object> map = new HashMap<>();
        map.put("db",dbsqMapper.dbxx(id).get(0));
        map.put("dbxq",dbsqMapper.dbxqcx(id, ""));
        return map;
    }

    public String scxgpd(Integer id){
        List<StoEntity> stocx = dbsqMapper.stocx(id);
        if(stocx.size()>0){
            return "该调拨申请单已入库,不可删除或更改";
        }else {
            return "ok";
        }
    }

    public String dbdel(Integer id){
        List<StoEntity> stocx = dbsqMapper.stocx(id);
        if(stocx.size()>0){
            return "该调拨申请单已入库,不可删除或更改";
        }else {
            List<Allotxq> dbxqcx = dbsqMapper.dbxqcx(id, "");
            for (Allotxq allotxq : dbxqcx) {
                dbxqDao.deleteById(allotxq.getAllotxqId());
            }
            dbDao.deleteById(id);
            return "ok";
        }
    }
}
