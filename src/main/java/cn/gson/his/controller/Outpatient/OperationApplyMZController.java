package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.InHospital.OperationApplyEntity;
import cn.gson.his.model.service.Outpatient.OperationApplyMZService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("wjc")
public class OperationApplyMZController {

    @Autowired
    OperationApplyMZService operationApplyMZService;


    @RequestMapping("selApp")
    //查询患者的门诊手术
    public List<OperationApplyEntity> selApp(String regMark){
        return operationApplyMZService.selApp(regMark,2);
    };
    //修改是否缴费还有填没填结果
    @RequestMapping("upApply")
    public int upApply(int opsLs,String regMark){
        return operationApplyMZService.upApply(opsLs,regMark);
    };
    //填写手术结果
    @RequestMapping("upApplyJG")
    public int upApplyJG(int opsLs,String indication,String regMark){
        return operationApplyMZService.upApplyJG(opsLs,indication,regMark);
    };

}
