package cn.gson.his.model.service.Drug;

import cn.gson.his.model.mappers.Drug.RkMapper;
import cn.gson.his.model.pojos.Drug.StoEntity;
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
public class RkService {
    @Autowired
    RkMapper rkMapper;

    public Map<String, Object> rkcx(int pageNo, int size,String why, String nr){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",rkMapper.rkcx(why,nr));
        map.put("total",page.getTotal());
        return map;
    }
}
