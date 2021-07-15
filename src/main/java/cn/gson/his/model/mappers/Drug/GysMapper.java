package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.ConEntity;
import cn.gson.his.model.pojos.Drug.DrugEntity;
import cn.gson.his.model.pojos.Drug.GysEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GysMapper {

    public List<GysEntity> selectgys(GysEntity gysEntity);

    public List<DrugEntity> ypcx(@Param("id") Integer id);

    public List<ConEntity> concx(@Param("id") Integer id);
}
