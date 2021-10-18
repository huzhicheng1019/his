package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.PayEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayMapper {
    //新增缴费记录
    public void addPay(PayEntity pay);
    //查询缴费记录
    public List<PayEntity> allPay(String payDate, String payName, String recordNo);
}
