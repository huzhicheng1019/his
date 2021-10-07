package cn.gson.his.model.service.Outpatient;


import cn.gson.his.model.mappers.InHospital.HospitalRegisterMapper;
import cn.gson.his.model.mappers.Outpatient.PatientMapper;
import cn.gson.his.model.mappers.Outpatient.TheHospitalMapper;
import cn.gson.his.model.pojos.InHospital.HospitalRegisterEntity;
import cn.gson.his.model.pojos.Outpatient.PatientdataEntity;
import cn.gson.his.model.pojos.Outpatient.TheHospitalEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class TheHospitalService {
    @Autowired
    TheHospitalMapper theHospitalMapper;

    //病人资料
    @Autowired
    PatientMapper patientMapper;

    //住院登记信息
    @Autowired
    HospitalRegisterMapper hospitalRegisterMapper;

    //查询所有住院申请表
    public Map<String,Object> selHospital(int page, int size,String content){
        Page<Object> p = PageHelper.startPage(page,size);
        List<Map<String,Object>> list = theHospitalMapper.selHospital(content);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",p.getTotal());
        return map;
    }

    //新增病人资料表,新增住院申请表
    public int insertPatient(PatientdataEntity patientdataEntity,TheHospitalEntity theHospitalEntity){
        //根据身份证查 是否已经住院了
        HospitalRegisterEntity hospitalRegisterEntity = hospitalRegisterMapper.selIdentity(patientdataEntity.getPatientIdentity());

        if(hospitalRegisterEntity != null){
            return 0;
        }


        //根据身份证查病人资料表是否有过这个病人的信息
        PatientdataEntity entity = patientMapper.selID(patientdataEntity.getPatientIdentity());
        //如果有资料就修改之前的资料 如果没有就新增
        if(entity == null){
            theHospitalMapper.insertPatient(patientdataEntity);


            theHospitalEntity.setPatientNo(patientdataEntity.getPatientNo());
            theHospitalMapper.insertHospital(theHospitalEntity);
        }else{

            //先新增 再删除
            PatientdataEntity br = new PatientdataEntity();
            br.setPatientName(patientdataEntity.getPatientName());
            br.setPatientSex(patientdataEntity.getPatientSex());
            br.setPatientAge(patientdataEntity.getPatientAge());
            br.setPatientPhone(patientdataEntity.getPatientPhone());
            br.setPatientInsu(patientdataEntity.getPatientInsu());
            br.setPatientIdentity(patientdataEntity.getPatientIdentity());
            br.setPatientPirth(patientdataEntity.getPatientPirth());
            theHospitalMapper.insertPatient(br);


            //删除原来的
            patientMapper.delPatient(entity.getPatientNo()+"");

            //新增住院申请
            theHospitalEntity.setPatientNo(br.getPatientNo());
            theHospitalMapper.insertHospital(theHospitalEntity);
        }

        return 1;

    }
    //直接申请住院申请表
    public void insertHospital(TheHospitalEntity theHospitalEntity){

        theHospitalMapper.insertHospital(theHospitalEntity);
    }
    //修改申请表状态
    public int updateState(String hospitalNo){
        return theHospitalMapper.updateState(hospitalNo);
    }

}
