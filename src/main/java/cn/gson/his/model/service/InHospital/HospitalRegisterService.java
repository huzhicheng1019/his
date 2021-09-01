package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.DoctorLeaveMapper;
import cn.gson.his.model.mappers.InHospital.HospitalRegisterMapper;
import cn.gson.his.model.pojos.Drug.DrugEntity;
import cn.gson.his.model.pojos.InHospital.DoctorLeaveEntity;
import cn.gson.his.model.pojos.InHospital.HospitalRegisterEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class HospitalRegisterService {
    @Autowired
    HospitalRegisterMapper hospitalRegisterMapper;
    @Autowired
    DoctorLeaveMapper doctorLeaveMapper;


    //新增住院登记
    public int insertReg(HospitalRegisterEntity hospitalRegisterEntity){
        return  hospitalRegisterMapper.insertReg(hospitalRegisterEntity);
    }

    //查询所有住院登记表
    public List<HospitalRegisterEntity> selReg(String text){
        return hospitalRegisterMapper.selReg(text);
    };

    //查询所有住院登记表 和 床位记录表
    public List<HospitalRegisterEntity> selRegBeds(HospitalRegisterEntity hospitalRegisterEntity){
        return hospitalRegisterMapper.selRegBeds(hospitalRegisterEntity);
    };

    /**
     * 查询病人所有信息
     */
    public List<HospitalRegisterEntity> selAll(String text){
        return hospitalRegisterMapper.selAll(text);
    };

    //查询执行医嘱
    public List<HospitalRegisterEntity> query(){
        return hospitalRegisterMapper.query();
    }


    //新增出院申请
    public int insertLea(DoctorLeaveEntity doctorLeave){
        int i = doctorLeaveMapper.insertLea(doctorLeave);
        if (i>0){
            return 1;
        }
        return 0;
    }

    //根据住院号查出院申请单
    public DoctorLeaveEntity selLea(String regMark){
        return  doctorLeaveMapper.selLea(regMark);
    }

    //修改出院申请（取消）
    public int updateLea(String leaReason,String leaId){
        int i =doctorLeaveMapper.updateLea(leaReason,leaId);
        if (i>0){
            return 1;
        }
        return 0;
    }

    //出院登记查询
    public List<HospitalRegisterEntity> selLeave(String text,String depaId){
        return hospitalRegisterMapper.selLeave(text,depaId);
    }

}
