package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.CheckoutEntity;
import cn.gson.his.model.pojos.Outpatient.SeleExamineCheckoutEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CheckoutMapper {

    //新增化验单
    public void addCheck(CheckoutEntity checkoutEntity);

    //修改化验收费状态
    public void upCheck(Integer checkoutState,Integer checkoutId);
    //查询所有有结果的检查检验
    public List<SeleExamineCheckoutEntity> seleExamineCheckout(String id);

    public List<CheckoutEntity> seleCheck(String checkoutId);
}
