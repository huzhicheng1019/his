package cn.gson.his.model.service.Outpatient;


import cn.gson.his.model.mappers.Outpatient.TheHospitalMapper;
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
    public void insertPatient(PatientdataEntity patientdataEntity,TheHospitalEntity theHospitalEntity){
         theHospitalMapper.insertPatient(patientdataEntity);

         theHospitalEntity.setPatientNo(patientdataEntity.getPatientNo());

        theHospitalMapper.insertHospital(theHospitalEntity);
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
