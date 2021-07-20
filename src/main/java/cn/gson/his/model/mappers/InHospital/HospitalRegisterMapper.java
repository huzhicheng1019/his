package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.InHospital.HospitalRegisterEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HospitalRegisterMapper {

    //新增住院登记
    public int insertReg(HospitalRegisterEntity hospitalRegisterEntity);

    //查询所有住院登记表
    public List<HospitalRegisterEntity> selReg(String text);


    //查询所有住院登记表 和 床位记录表
     public List<HospitalRegisterEntity> selRegBeds(HospitalRegisterEntity hospitalRegisterEntity);

}
