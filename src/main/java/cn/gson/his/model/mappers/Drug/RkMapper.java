package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.StoEntity;
import cn.gson.his.model.pojos.Drug.StojlEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface RkMapper {
    public List<StoEntity> rkcx(@Param("why") String why, @Param("nr") String nr, @Param("qssj") Date qssj, @Param("jssj") Date jssj);

    public List<StojlEntity> stojlcx(@Param("id") Integer id, @Param("nr") String nr);

    public List<StoEntity> rkcxid(Integer id);

    public List<StoEntity> cgrkxs(@Param("id") String id);
}