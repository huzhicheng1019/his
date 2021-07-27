package cn.gson.his.model.service.Power;

import cn.gson.his.model.dao.Power.ShiftDao;
import cn.gson.his.model.mappers.Power.ShiftMapper;
import cn.gson.his.model.pojos.Power.Shift;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class ShiftService {

    @Autowired
    ShiftMapper mapper;

    @Autowired
    ShiftDao dao;

    /**
     * 分页查询
     * @param pageNo
     * @param size
     * @return
     */
    public Map<String, Object> allShift(Integer pageNo,Integer size){
        Page<Object> p = PageHelper.startPage(pageNo,size);
        List<Map<String,Object>> list = mapper.allShift();
        Map<String,Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",p.getTotal());
        return map;
    }

    public int addShift(Shift shift){
        Shift save = dao.save(shift);
        return save==null?0:1;
    }
}
