package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.Drug.DrugEntity;
import cn.gson.his.model.pojos.InHospital.DoctorCheckEntity;
import cn.gson.his.model.pojos.InHospital.DoctorExecuteEntity;
import cn.gson.his.model.pojos.InHospital.HospitalRegisterEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HospitalRegisterMapper {

    //新增住院登记
    public int insertReg(HospitalRegisterEntity hospitalRegisterEntity);

    //查询所有住院登记表
    public List<HospitalRegisterEntity> selReg(@Param("depaId")String depaId,@Param("beginTime")String beginTime,@Param("endTime")String endTime,@Param("content")String content);


    //查询所有住院登记表 和 床位记录表
     public List<HospitalRegisterEntity> selRegBeds(@Param("depaId")String depaId,@Param("beginTime")String beginTime,@Param("endTime")String endTime,@Param("content")String content);


    /**
     * 查询病人所有信息
     */
    public List<HospitalRegisterEntity> selAll(@Param("text")String text, @Param("depaId") String depaId);


    //查询执行医嘱
    public List<HospitalRegisterEntity> query(@Param("text")String text,@Param("depaId") String depaId);



    //出院登记查询
    public List<HospitalRegisterEntity> selLeave(@Param("text")String text, @Param("depaId") String depaId);


    //转科后修改科室和主治医生
    public int updateReg(HospitalRegisterEntity hospitalRegister);

    //根据住院号查病人
    public HospitalRegisterEntity look(String regMark);

    //根据身份证查病人是否已经住院
    public HospitalRegisterEntity selIdentity(String patientIdentity);

    //查询所有出院申请
    public List<HospitalRegisterEntity> leaSel(@Param("depaId")String depaId,@Param("beginTime")String beginTime,@Param("endTime")String endTime,@Param("content")String content);

    //新增出院登记
    public int insertCheck(DoctorCheckEntity doctorCheckEntity);

    //根据住院号修改住院登记表状态
    public int updateRegister(String regMark);
}
