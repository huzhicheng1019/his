package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.GysDao;
import cn.gson.his.model.mappers.Drug.GysMapper;
import cn.gson.his.model.pojos.Drug.ConEntity;
import cn.gson.his.model.pojos.Drug.DrugEntity;
import cn.gson.his.model.pojos.Drug.GysEntity;
import cn.gson.his.model.pojos.Drug.LbEntity;
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
public class GysService {
    @Autowired
    GysMapper gysMapper;

    @Autowired
    GysDao gysDao;

    public Map<String,Object> lbcx(int pageNo, int size,GysEntity gysEntity){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("gys",gysMapper.selectgys(gysEntity));
        map.put("total",page.getTotal());
        return map;
    }

    public void saveYplb(GysEntity gysEntity){
        gysDao.save(gysEntity);
    }

    public void del(Integer id){
        gysDao.deleteById(id);
    }

    public List<DrugEntity> ypcx(Integer id){
        return gysMapper.ypcx(id);
    }

    public List<ConEntity> concx(Integer id){
        return gysMapper.concx(id);
    }
}
