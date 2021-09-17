package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.Outpatient.PatientdataEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatientDataMapper {
    //根据id查病人资料
    public PatientdataEntity selPat(String patientNo);
}
