package cn.gson.his.model.mappers.Power;

import cn.gson.his.model.pojos.Power.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScheduMapper {

    public Integer allDeptId(String name);//根据部门名称查询部门id

    public List<Department> deptIdDepa(Integer id);//根据部门id查询科室

    public List<Title> deptIdTit(Integer id);//根据部门id查询职称

    public List<Employee> depaIdByEmp(@Param("dept") Integer dept,@Param("depa") Integer depa);//根据部门和科室查询员工

    public List<Shift> allShift();//查询所有班次

    public int addSchedu(List<Schedu> list);//新增排班表
}
