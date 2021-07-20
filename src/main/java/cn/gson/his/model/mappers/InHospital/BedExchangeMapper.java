package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.InHospital.BedExchangeEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BedExchangeMapper {
    //新增床位调换表
    public int insertEx(BedExchangeEntity bedExchange);


}
