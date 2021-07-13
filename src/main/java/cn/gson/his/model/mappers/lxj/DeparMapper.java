package cn.gson.his.model.mappers.lxj;


import cn.gson.his.model.pojos.lxj.Department;
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
