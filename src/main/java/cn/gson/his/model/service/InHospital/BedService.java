package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.BedMapper;
import cn.gson.his.model.pojos.InHospital.BedEntity;
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
    public Map<String,Object> selectBed(int page,int size,String content,String screen){
        Page<Object> p = PageHelper.startPage(page,size);
        List<Map<String,Object>> list = bedMapper.selectBed(content,screen);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",p.getTotal());
        return map;
    }
    //新增床位
    public int insertBed(BedEntity bedEntity){
        return bedMapper.insertBed(bedEntity);
    }
    //修改床位
    public int updateBed(BedEntity bedEntity){
        return bedMapper.updateBed(bedEntity);
    }



}
