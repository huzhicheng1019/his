package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.InHospital.OperationApplyEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperationApplyMZMapper {

    //查询患者的门诊手术
    public List<OperationApplyEntity> selApp(String regMark,int opsLs);
    //修改是否缴费还有填没填结果
    public int upApply(int opsLs,String regMark);
    //填写手术结果
    public int upApplyJG(int opsLs,String indication,String regMark);
}
