package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.GysEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GysMapper {

    public List<GysEntity> selectgys();
}
