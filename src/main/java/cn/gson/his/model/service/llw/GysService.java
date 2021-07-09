package cn.gson.his.model.service.llw;

import cn.gson.his.model.dao.llw.GysDao;
import cn.gson.his.model.mappers.llw.GysMapper;
import cn.gson.his.model.pojos.llw.GysEntity;
import cn.gson.his.model.pojos.llw.LbEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class GysService {
    @Autowired
    GysMapper gysMapper;

    @Autowired
    GysDao gysDao;

    public Map<String,Object> lbcx(int pageNo, int size){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("gys",gysMapper.selectgys());
        map.put("total",page.getTotal());
        return map;
    }

    public void saveYplb(GysEntity gysEntity){
        gysDao.save(gysEntity);
    }

    public void del(Integer id){
        gysDao.deleteById(id);
    }

}
