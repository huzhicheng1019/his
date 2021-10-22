package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.Allotxq;
import cn.gson.his.model.pojos.Drug.ChecksEntity;
import cn.gson.his.model.pojos.Drug.Checkxq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface PdMapper {
    public List<ChecksEntity> pdcx(@Param("nr") String nr, @Param("qssj") Date qssj, @Param("jssj") Date jssj);

    public List<Checkxq> pdxqcx(@Param("id") String id, @Param("nr") String nr);

}
