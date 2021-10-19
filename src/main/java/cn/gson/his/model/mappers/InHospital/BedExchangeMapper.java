package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.InHospital.BedExchangeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BedExchangeMapper {
    //新增床位调换表
    public int insertEx(BedExchangeEntity bedExchange);

    //查询床位调换记录
    public List<BedExchangeEntity> selBedExchange(@Param("depaId")String depaId, @Param("beginTime")String beginTime, @Param("endTime")String endTime, @Param("content")String content);

}
