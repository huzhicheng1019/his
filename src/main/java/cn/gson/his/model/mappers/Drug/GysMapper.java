package cn.gson.his.model.mappers.llw;

import cn.gson.his.model.pojos.llw.ConEntity;
import cn.gson.his.model.pojos.llw.DrugEntity;
import cn.gson.his.model.pojos.llw.GysEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GysMapper {

    public List<GysEntity> selectgys(GysEntity gysEntity);

    public List<DrugEntity> ypcx(@Param("id") Integer id);

    public List<ConEntity> concx(@Param("id") Integer id);
}
