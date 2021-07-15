package cn.gson.his.model.mappers.Power;


import cn.gson.his.model.pojos.Power.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    //查询住院部的医生
    public List<Employee> selDoctor(Integer depaId);


}
