package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.StoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RkMapper {
    public List<StoEntity> rkcx(@Param("why") String why,@Param("nr") String nr);
}
