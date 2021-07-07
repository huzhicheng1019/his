package cn.gson.his.model.service.hzc;

import cn.gson.his.model.mappers.hzc.BedMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class BedService {
    @Autowired
    BedMapper bedMapper;

    //查询所有床位 带分页
    public Map<String,Object> selectBed(int page,int size){
        Page<Object> p = PageHelper.startPage(page,size);
        List<Map<String,Object>> list = bedMapper.selectBed();
        Map<String,Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",p.getTotal());
        return map;
    }



}
