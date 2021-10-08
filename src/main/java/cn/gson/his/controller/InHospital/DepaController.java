package cn.gson.his.controller.InHospital;

import cn.gson.his.model.pojos.InHospital.TransferEntity;
import cn.gson.his.model.pojos.Outpatient.CaseHistoryEntity;
import cn.gson.his.model.pojos.Outpatient.CaseHistoryPartiEntity;
import cn.gson.his.model.pojos.Power.Department;
import cn.gson.his.model.service.InHospital.DepaSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class DepaController {

    @Autowired
    DepaSerivce serivce;


    //查询当天值班的医生
    @RequestMapping("/selDuty")
    public List<Department> selDuty(Integer deparId){
        return serivce.selDuty(deparId);
    }

    //根据身份证查病人的病历
    @RequestMapping("/IdentityCaseHistory")
    public List<CaseHistoryEntity> IdentityCaseHistory(String patientIdentity){
        return serivce.IdentityCaseHistory(patientIdentity);
    }

    //根据身份证查当前使用的病历
    @RequestMapping("/IdentityCaseHistoryState")
    public CaseHistoryEntity IdentityCaseHistoryState(String patientIdentity){
        return serivce.IdentityCaseHistoryState(patientIdentity);
    }

    //确定新增病历
    @RequestMapping("/insertCaseHistory")
    public int insertCaseHistory(CaseHistoryEntity caseHistoryEntity, CaseHistoryPartiEntity caseHistoryPartiEntity){
        serivce.insertCaseHistory(caseHistoryEntity,caseHistoryPartiEntity);
        return 0;
    }





    //确认转科   修改住院登记表 新增转科记录 新增病历
    @RequestMapping("/tran")
    public int demo(@RequestBody TransferEntity transfer){
        int i = serivce.insertTr(transfer);
        if (i>0){
            return 1;
        }
        return 0;
    }
}
