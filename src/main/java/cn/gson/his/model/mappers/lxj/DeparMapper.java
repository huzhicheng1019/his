package cn.gson.his.model.mappers.lxj;


import cn.gson.his.model.pojos.lxj.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeparMapper {

    public List<Department> allDepar();
}
