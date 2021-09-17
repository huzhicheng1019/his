package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.Drug.DrugEntity;
import cn.gson.his.model.pojos.InHospital.HospitalRegisterEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HospitalRegisterMapper {

    //新增住院登记
    public int insertReg(HospitalRegisterEntity hospitalRegisterEntity);

    //查询所有住院登记表
    public List<HospitalRegisterEntity> selReg(String text);


    //查询所有住院登记表 和 床位记录表
     public List<HospitalRegisterEntity> selRegBeds(HospitalRegisterEntity hospitalRegisterEntity);


    /**
     * 查询病人所有信息
     */
    public List<HospitalRegisterEntity> selAll(@Param("text")String text, @Param("depaId") String depaId);


    //查询执行医嘱
    public List<HospitalRegisterEntity> query();


    //出院登记查询
    public List<HospitalRegisterEntity> selLeave(@Param("text")String text, @Param("depaId") String depaId);


    //转科后修改科室和主治医生
    public int updateReg(HospitalRegisterEntity hospitalRegister);

    //根据住院号查病人
    public HospitalRegisterEntity look(String regMark);


}
