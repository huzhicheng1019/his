package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.CheckoutEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckoutMapper {

    //新增化验单
    public void addCheck(CheckoutEntity checkoutEntity);

    //修改化验收费状态
    public void upCheck(Integer checkoutState,Integer checkoutId);

}
