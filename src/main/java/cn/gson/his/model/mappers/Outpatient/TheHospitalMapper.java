package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.PatientdataEntity;
import cn.gson.his.model.pojos.Outpatient.TheHospitalEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TheHospitalMapper {

    //查询所有住院申请表
    public List<TheHospitalEntity> selHospital(@Param("depaId")String depaId,@Param("beginTime")String beginTime,@Param("endTime")String endTime,@Param("content")String content);

    //新增病人资料表
    public int insertPatient(PatientdataEntity patientdataEntity);

    //新增住院申请表
    public int insertHospital(TheHospitalEntity theHospitalEntity);

    //修改申请表状态
    public int updateState(String hospitalNo);
}
