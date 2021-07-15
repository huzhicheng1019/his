package cn.gson.his.model.mappers.lxj;


import cn.gson.his.model.pojos.lxj.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper {

    //查询住院部的医生
    public List<Employee> selDoctor(Integer depaId);


    public List<Map<String,Object>> allEmp();

}
