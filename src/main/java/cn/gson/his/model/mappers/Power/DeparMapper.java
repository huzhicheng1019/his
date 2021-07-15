package cn.gson.his.model.mappers.Power;


import cn.gson.his.model.pojos.Power.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeparMapper {

    /**
     * 查询所有科室
     * @return
     */
    public List<Department> allDepar();
}
