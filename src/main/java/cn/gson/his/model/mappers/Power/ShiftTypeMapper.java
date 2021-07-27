package cn.gson.his.model.mappers.Power;

import cn.gson.his.model.pojos.Power.ShiftType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShiftTypeMapper {

    public List<ShiftType> allType();
}
