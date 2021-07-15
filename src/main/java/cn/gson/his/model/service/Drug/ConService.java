package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.ConDao;
import cn.gson.his.model.mappers.Drug.ConMapper;
import cn.gson.his.model.pojos.Drug.ConEntity;
import cn.gson.his.model.pojos.Drug.DrugEntity;
import cn.gson.his.model.pojos.Drug.LibraryxqEntity;
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
public class ConService {
    @Autowired
    ConMapper conMapper;

    @Autowired
    ConDao conDao;

    public Map<String,Object> conselect(int pageNo, int size, ConEntity conEntity){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",conMapper.concx(conEntity));
        map.put("gys",conMapper.selectgys());
        map.put("total",page.getTotal());
        return map;
    }

    public void savecon(ConEntity conEntity){
        conDao.save(conEntity);
    }

    public void del(Integer id){
        conDao.deleteById(id);
    }

    public List<LibraryxqEntity> selectck(Integer id){
        return conMapper.selectck(id);
    }
}
