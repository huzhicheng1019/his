package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.Power.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper {
    //根据员工id查员工
    Employee findEmp(String empId);
}
