package cn.gson.his.model.mappers.lxj;

import cn.gson.his.model.pojos.lxj.DepartmentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeparMapper {

    public List<DepartmentEntity> allDepar();
}
