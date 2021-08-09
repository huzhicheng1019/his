package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.InHospital.DoctorExecuteEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DoctorExecuteMapper {

    //新增执行记录表
    public int insertExe(DoctorExecuteEntity doctorExecuteEntity);
}
