package cn.gson.his.controller.InHospital;


import cn.gson.his.model.pojos.Drug.DrugEntity;
import cn.gson.his.model.pojos.InHospital.DoctorExecuteEntity;
import cn.gson.his.model.pojos.InHospital.DoctorLeaveEntity;
import cn.gson.his.model.pojos.InHospital.HospitalRegisterEntity;
import cn.gson.his.model.service.InHospital.HospitalRegisterService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class HospitalRegisterController {

    @Autowired
    HospitalRegisterService reg;

    //新增住院登记
    @RequestMapping("/insertReg")
    public int demo(@RequestBody String hospitalRegisterEntity){
        HospitalRegisterEntity HospReg = JSONObject.parseObject(hospitalRegisterEntity, HospitalRegisterEntity.class);
        int i = reg.insertReg(HospReg);
        if(i>0){
            return 1;
        }
        return 0;
    }

    //查询所有住院登记表
    @RequestMapping("/selReg")
    public List<HospitalRegisterEntity> demo1(String hospitalRegisterEntity){
        HospitalRegisterEntity hospitalRegisterEntity1 = JSONObject.parseObject(hospitalRegisterEntity, HospitalRegisterEntity.class);
        return reg.selReg(hospitalRegisterEntity1);
    }


    //查询所有住院登记表 和 床位记录表
    @RequestMapping("/selRegBeds")
    public List<HospitalRegisterEntity> demo2(String hospitalRegister){

        HospitalRegisterEntity hospitalRegisterEntity = JSONObject.parseObject(hospitalRegister, HospitalRegisterEntity.class);

        return reg.selRegBeds(hospitalRegisterEntity);
    }


    /**
     * 查询病人所有信息
     */
    @RequestMapping("/selAll")
    public List<HospitalRegisterEntity> demo3(String text,String depaId){
        return reg.selAll(text,depaId);
    };

    //查询执行医嘱
    @RequestMapping("/query")
    public List<HospitalRegisterEntity> demo4(String text,String depaId){
        return reg.query(text,depaId);
    };



    //新增出院申请
    @RequestMapping("/insertLea")
    public int demo5(String doctorLeaveEntity){
        DoctorLeaveEntity  aa = JSONObject.parseObject(doctorLeaveEntity,DoctorLeaveEntity.class);

        return reg.insertLea(aa);

    };

    //根据住院号查出院申请单
    @RequestMapping("/selLea")
    public DoctorLeaveEntity demo6(String regMark){
        return reg.selLea(regMark);
    };

    //修改出院申请（取消）
    @RequestMapping("/updateLea")
    public int demo7(String leaReason,String leaId){
        return reg.updateLea(leaReason,leaId);
    };


    //出院登记查询
    @RequestMapping("/selLeave")
    public List<HospitalRegisterEntity> demo8(String text,String depaId){
        return reg.selLeave(text,depaId);
    };


    //查询所有出院申请
    @RequestMapping("/leaSel")
    public List<HospitalRegisterEntity> leaSel(String hospitalRegisterEntity){
        HospitalRegisterEntity hospitalRegisterEntity1 = JSONObject.parseObject(hospitalRegisterEntity, HospitalRegisterEntity.class);
        return reg.leaSel(hospitalRegisterEntity1);
    }


    //确定出院
    @RequestMapping("/confirmLeave")
    public int confirmLeave(String regMark,String Tprice){

        int i = reg.leave(regMark, Tprice);
        if(i>0){
            return 1;
        }
        return 0;
    };


}
