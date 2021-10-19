package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.OperationApplyMZMapper;
import cn.gson.his.model.pojos.InHospital.OperationApplyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationApplyMZService {


    @Autowired OperationApplyMZMapper operationApplyMZMapper;



    //查询患者的门诊手术
    public List<OperationApplyEntity> selApp(String regMark, int opsLs){
            return operationApplyMZMapper.selApp(regMark,opsLs);
    };
    //修改是否缴费还有填没填结果
    public int upApply(int opsLs,String regMark){
        return operationApplyMZMapper.upApply(opsLs,regMark);
    };
    //填写手术结果
    public int upApplyJG(int opsLs,String indication,String regMark){
            return operationApplyMZMapper.upApplyJG(opsLs,indication,regMark);
    };

}
