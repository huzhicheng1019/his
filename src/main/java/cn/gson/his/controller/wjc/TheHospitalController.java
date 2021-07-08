package cn.gson.his.controller.wjc;


import cn.gson.his.model.pojos.wjc.PatientdataEntity;
import cn.gson.his.model.pojos.wjc.TheHospitalEntity;
import cn.gson.his.model.service.wjc.TheHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class TheHospitalController {
    @Autowired
    TheHospitalService theHospitalService;

    //查询所有住院申请表
    @RequestMapping("/selHospital")
    public Map<String,Object> demo(Integer pageNo, Integer pageSize){
        return theHospitalService.selHospital(pageNo,pageSize);
    }

    //新增病人资料表 新增住院申请表
    @RequestMapping("/insert")
    public int demo1(PatientdataEntity patientdataEntity, TheHospitalEntity theHospitalEntity){


         theHospitalService.insertPatient(patientdataEntity);

        return theHospitalService.insertHospital(theHospitalEntity);
    }


}
