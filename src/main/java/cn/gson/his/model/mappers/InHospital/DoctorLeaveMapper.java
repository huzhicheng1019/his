package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.InHospital.DoctorLeaveEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DoctorLeaveMapper {
    //新增出院申请单
    public int insertLea(DoctorLeaveEntity doctorLeave);

    //根据住院号查申请单
    public DoctorLeaveEntity selLea(String regMark);

    //修改出院申请（取消）
    public int updateLea(@Param("leaReason")String leaReason, @Param("leaId") String leaId);

}
