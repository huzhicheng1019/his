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
     * @param dept
     * @param startDate
     * @param endDate
     * @return
     */
    List<Map<String,Object>> allDept(@Param("dept")Dept dept, @Param("startDate")Timestamp startDate,@Param("endDate")Timestamp endDate);
}
