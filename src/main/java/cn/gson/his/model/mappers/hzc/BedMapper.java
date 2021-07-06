package cn.gson.his.model.mappers.hzc;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BedMapper {
        //查询所有床位 带分页
        public List<Map<String,Object>> selectBed();

}
