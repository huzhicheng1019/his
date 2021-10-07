package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.InHospital.DoctorExecuteEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DoctorExecuteMapper {

    //新增执行记录表
    public int insertExe(DoctorExecuteEntity doctorExecuteEntity);


    //查询当天的医嘱执行记录
    public List<DoctorExecuteEntity> queryRecord(@Param("text")String text, @Param("depaId") String depaId);
}
