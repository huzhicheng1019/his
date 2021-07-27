package cn.gson.his.model.service.Power;

import cn.gson.his.model.mappers.Power.ShiftTypeMapper;
import cn.gson.his.model.pojos.Power.ShiftType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ShiftTypeService {

    @Autowired
    ShiftTypeMapper mapper;

    public List<ShiftType> allType(){
        return mapper.allType();
    }
}
