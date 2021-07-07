package cn.gson.his.model.service.llw;

import cn.gson.his.model.mappers.llw.YpMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class YpService {
    @Autowired
    YpMapper ypMapper;

    public Map<String,Object> ypselect(int pageNo, int size){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",ypMapper.selectyp());
        map.put("total",page.getTotal());
        return map;
    }
}
