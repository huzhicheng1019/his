package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.Power.Department;
import cn.gson.his.model.pojos.Power.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepaMapper {
    //查询某个科室当天值班的人
    List<Department> selDuty(Integer deparId);


}
