package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.ReturnPremiumEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReturnPremiumMapper{
    //新增退费单
    public int insertReturn(ReturnPremiumEntity premium);
    //查询退费单
    public List<ReturnPremiumEntity> seleReturn(ReturnPremiumEntity returnPremiumEntity);
}
