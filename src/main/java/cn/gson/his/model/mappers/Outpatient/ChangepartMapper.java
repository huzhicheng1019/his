package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.ChangepartEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChangepartMapper {

    //新增详情
    public void addChangepart(ChangepartEntity changepartEntity);

    //查询化验
    public List<ChangepartEntity> allChangepart(String checkoutId);

    //修改化验
    public void upChangepart(String result,Integer checkout);

    //查询缴完费的缴费化验
    public List<ChangepartEntity> seleCheckJF(String checkoutId);
    //修改是否填写结果
    public int upChangepartJG(int state,int changepartNo);
    //查询这个患者有多少化验写完结果了
    public List<ChangepartEntity> seleCheckJG(String checkoutId);

}
