package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.InHospital.DoctorStopEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DoctorStopMapper {
    //新增医嘱停用记录表
    public int insertStop(DoctorStopEntity doctorStop );
}
