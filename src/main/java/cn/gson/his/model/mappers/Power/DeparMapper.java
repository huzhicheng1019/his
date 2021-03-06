package cn.gson.his.model.mappers.Power;


import cn.gson.his.model.pojos.Power.Department;
import cn.gson.his.model.pojos.Power.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Mapper
public interface DeparMapper {

    /**
     * 查询所有科室
     * @return
     */
    public List<Department> allDepar();
    //查询所有门诊的科室
    public List<Department> allDepar1();
    //查询所有住院的科室
    public List<Department> allDepar2();

    public List<Department> pageDepar(@Param("name") String name, @Param("startDate") Timestamp startDate, @Param("endDate")Timestamp endDate);
}
