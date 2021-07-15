package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.YplbDao;
import cn.gson.his.model.mappers.Drug.YplbMapper;
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
public class YplbService {
    @Autowired
    YplbMapper yplbMapper;

    @Autowired
    YplbDao yplbDao;

    public Map<String,Object> lbcx(int pageNo,int size,LbEntity lbEntity){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("lb",yplbMapper.lbcx(lbEntity));
        map.put("total",page.getTotal());
        return map;
    }

    public void saveYplb(LbEntity lbEntity){
        yplbDao.save(lbEntity);
    }

    public void del(Integer id){
        yplbDao.deleteById(id);
    }

    public List<DrugEntity> ypcx(Integer id){
        return yplbMapper.ypcx(id);
    }
}
