package cn.gson.his.controller.Outpatient;


import cn.gson.his.model.pojos.Outpatient.DoctorrecordEntity;
import cn.gson.his.model.pojos.Outpatient.PatientdataEntity;
import cn.gson.his.model.pojos.Outpatient.TheHospitalEntity;
import cn.gson.his.model.service.Outpatient.DoctorrecordService;
import cn.gson.his.model.service.Outpatient.TheHospitalService;
import com.alibaba.fastjson.JSONObject;
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

    @Autowired
    DoctorrecordService doctorrecordService;

    //查询所有住院申请表
    @RequestMapping("/selHospital")
    public Map<String,Object> demo(Integer pageNo, Integer pageSize,String content){
        return theHospitalService.selHospital(pageNo,pageSize,content);
    }

    //新增病人资料表,新增住院申请表
    @RequestMapping("/insert")
    public int demo1( String patient, Integer depaId){

            PatientdataEntity patientdataEntity1 = JSONObject.parseObject(patient, PatientdataEntity.class);

            TheHospitalEntity theHospitalEntity = new TheHospitalEntity();
            theHospitalEntity.setDepaId(depaId);

            return theHospitalService.insertPatient(patientdataEntity1,theHospitalEntity);
    }
    //直接新增住院申请表
    @RequestMapping("/insertHospital")
    public void insertHospital(Integer patient,Integer depaId,Integer recordNo){
        TheHospitalEntity theHospitalEntity = new TheHospitalEntity();
        theHospitalEntity.setDepaId(depaId);

        theHospitalEntity.setPatientNo(patient);
        System.out.println(recordNo);
        DoctorrecordEntity doctor = new DoctorrecordEntity();
        doctor.setAttState("已诊");

        doctor.setRecordNo(recordNo);

        doctorrecordService.upDoctorrecord(doctor);

        theHospitalService.insertHospital(theHospitalEntity);

    }
    //修改申请表状态
    @RequestMapping("/updateState")
    public void demo2(String hospitalNo){
        try{
            theHospitalService.updateState(hospitalNo);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
