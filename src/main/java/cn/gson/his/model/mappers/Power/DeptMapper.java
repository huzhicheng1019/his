package cn.gson.his.model.mappers.Power;

import cn.gson.his.model.pojos.Power.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Mapper
public interface DeptMapper {

    /**
     * 分页查询所有部门，带筛选
     * @param name
     * @param startDate
     * @param endDate
     * @return
     */
    List<Dept> allDept(@Param("name")String name, @Param("startDate")Timestamp startDate,@Param("endDate")Timestamp endDate);
}
