package cn.gson.his.model.mappers.wjc;

import cn.gson.his.model.pojos.wjc.PatientdataEntity;
import cn.gson.his.model.pojos.wjc.TheHospitalEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TheHospitalMapper {

    //查询所有住院申请表
    public List<Map<String,Object>> selHospital();

    //新增病人资料表
    public int insertPatient(PatientdataEntity patientdataEntity);

    //新增住院申请表
    public int insertHospital(TheHospitalEntity theHospitalEntity);

}
