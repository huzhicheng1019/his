package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.DepaMapper;
import cn.gson.his.model.mappers.InHospital.HospitalRegisterMapper;
import cn.gson.his.model.mappers.InHospital.TransferMapper;
import cn.gson.his.model.pojos.InHospital.HospitalRegisterEntity;
import cn.gson.his.model.pojos.InHospital.TransferEntity;
import cn.gson.his.model.pojos.Power.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepaSerivce {

    @Autowired
    DepaMapper mapper;

    //转科记录
    @Autowired
    TransferMapper transferMapper;

    //住院登记表
    @Autowired
    HospitalRegisterMapper hospitalRegister;

    //查询当天值班的医生
    public List<Department> selDuty(Integer deparId){
        return  mapper.selDuty(deparId);
    }


    //新增转科记录    修改住院登记表
    public int insertTr(TransferEntity transfer){

        //修改住院登记表的科室 主治医生id和名字
        HospitalRegisterEntity look = hospitalRegister.look(transfer.getRegMark());
        look.setDepaId(transfer.getNewDepa());
        look.setDoctorId(transfer.getNewDoctorId());
        look.setDoctorName(transfer.getNewDoctorName());



        //新增转科记录
        return transferMapper.insertTr(transfer);
    }
}
