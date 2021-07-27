package cn.gson.his.model.mappers.Power;

import cn.gson.his.model.pojos.Power.Shift;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShiftMapper {

    public List<Map<String,Object>> allShift();
}
