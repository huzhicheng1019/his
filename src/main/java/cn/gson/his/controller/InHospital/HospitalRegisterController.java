package cn.gson.his.controller.InHospital;


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
    public List<HospitalRegisterEntity> demo1(String text){
        return reg.selReg(text);
    }

}
