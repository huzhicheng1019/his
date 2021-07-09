package cn.gson.his.model.mappers.lxj;

import cn.gson.his.model.pojos.lxj.RoleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {

    public List<Map<String,Object>> allRole();
}
