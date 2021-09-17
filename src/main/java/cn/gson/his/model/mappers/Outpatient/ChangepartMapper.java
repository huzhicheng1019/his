package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.ChangepartEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChangepartMapper {

    //新增详情
    public void addChangepart(ChangepartEntity changepartEntity);

    //查询化验
    public void allChangepart(String checkoutId);

    //修改化验
    public void upChangepart(String result,Integer checkout);

}
