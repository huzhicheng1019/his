package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.GysDao;
import cn.gson.his.model.mappers.Drug.GysMapper;
import cn.gson.his.model.pojos.Drug.GysEntity;
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
