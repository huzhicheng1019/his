package cn.gson.his.model.mappers.Power;

import cn.gson.his.model.pojos.Power.vo.echarts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HomeworkMapper {

    List<Integer> isHostYear(String year);

    List<Integer> isOutYear(String year);

    List<Map<String,Object>> allHospital(String year);

    List<Map<String,Object>> allOutpatient(String year);
}
