package cn.gson.his.model.service.wjc;


import cn.gson.his.model.mappers.wjc.TheHospitalMapper;
import cn.gson.his.model.pojos.wjc.PatientdataEntity;
import cn.gson.his.model.pojos.wjc.TheHospitalEntity;
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
    public Map<String,Object> selHospital(int page, int size){
        Page<Object> p = PageHelper.startPage(page,size);
        List<Map<String,Object>> list = theHospitalMapper.selHospital();
        Map<String,Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",p.getTotal());
        return map;
    }

    //新增病人资料表
    public int insertPatient(PatientdataEntity patientdataEntity){
        return theHospitalMapper.insertPatient(patientdataEntity);
    }

    //新增住院申请表
    public int insertHospital(TheHospitalEntity theHospitalEntity){
        return theHospitalMapper.insertHospital(theHospitalEntity);
    }

}
