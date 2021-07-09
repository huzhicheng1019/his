package cn.gson.his.model.mappers.llw;

import cn.gson.his.model.pojos.llw.GysEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GysMapper {

    public List<GysEntity> selectgys();
}
