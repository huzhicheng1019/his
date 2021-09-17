package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.PayEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayMapper {
    //新增缴费记录
    public void addPay(PayEntity pay);
}
