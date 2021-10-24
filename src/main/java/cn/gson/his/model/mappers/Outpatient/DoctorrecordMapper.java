package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.DoctorrecordEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorrecordMapper {
//    查询就诊记录
    public List<DoctorrecordEntity>allDoctorrecord(String cxtj);
//    新增就诊记录
    public int addDoctorrecord(DoctorrecordEntity doctorre);
//    修改就诊记录
    public int upDoctorrecord(DoctorrecordEntity doctorre);
// 科室主治医生
    public List<DoctorrecordEntity> alldoctor(DoctorrecordEntity doctorre);
//    根据就诊号查询就诊记录的患者
    public List<DoctorrecordEntity> allPatien(String recordNo);
}
