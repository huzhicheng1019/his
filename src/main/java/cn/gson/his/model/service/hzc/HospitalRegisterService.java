package cn.gson.his.model.service.hzc;

import cn.gson.his.model.mappers.hzc.HospitalRegisterMapper;
import cn.gson.his.model.pojos.hzc.HospitalRegisterEntity;
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
    public List<HospitalRegisterEntity> selReg(){
        return hospitalRegisterMapper.selReg();
    };
}
