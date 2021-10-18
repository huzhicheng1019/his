package cn.gson.his.model.mappers.Power;

import cn.gson.his.model.pojos.Power.vo.echarts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeworkMapper {

    List<echarts> allHospital();
}
