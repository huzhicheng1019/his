package cn.gson.his.model.service.Drug;

import cn.gson.his.model.mappers.Drug.SpMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class SpService {
    @Autowired
    SpMapper spMapper;

    public Map<String,Object> spcx(int pageNo, int size, String why, String nr, Date qssj, Date jssj){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("cg",spMapper.spselect(why,nr,qssj,jssj));
        map.put("total",page.getTotal());
        return map;
    }
}
