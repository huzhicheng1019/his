package cn.gson.his.model.service.llw;

import cn.gson.his.model.dao.llw.YpDao;
import cn.gson.his.model.mappers.llw.YpMapper;
import cn.gson.his.model.pojos.llw.DrugEntity;
import cn.gson.his.model.pojos.llw.LibraryxqEntity;
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
public class YpService {
    @Autowired
    YpMapper ypMapper;

    @Autowired
    YpDao ypDao;

    public Map<String,Object> ypselect(int pageNo, int size,DrugEntity drugEntity){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",ypMapper.selectyp(drugEntity));
        map.put("gys",ypMapper.selectgys());
        map.put("lb",ypMapper.selectlb());
        map.put("total",page.getTotal());
        return map;
    }

    public void saveYp(DrugEntity drugEntity){
        ypDao.save(drugEntity);
    }

    public void del(Integer id){
        ypDao.deleteById(id);
    }

    public List<LibraryxqEntity> selectck(Integer id){
        return ypMapper.selectck(id);
    }
}
