package cn.gson.his.model.service.Drug;

import cn.gson.his.model.mappers.Drug.CangkMapper;
import cn.gson.his.model.mappers.Drug.DbsqMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class DbsqService {
    @Autowired
    DbsqMapper dbsqMapper;
    @Autowired
    CangkMapper cangkMapper;

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

    public Map<String,Object> dbckxqcx(Integer id, String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",cangkMapper.ckxqcx(id,nr));
        return map;
    }
}
