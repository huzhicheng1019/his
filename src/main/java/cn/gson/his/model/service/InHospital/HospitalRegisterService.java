package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.HospitalRegisterMapper;
import cn.gson.his.model.pojos.Drug.DrugEntity;
import cn.gson.his.model.pojos.InHospital.HospitalRegisterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class HospitalRegisterService {
    @Autowired
    HospitalRegisterMapper hospitalRegisterMapper;

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


}
