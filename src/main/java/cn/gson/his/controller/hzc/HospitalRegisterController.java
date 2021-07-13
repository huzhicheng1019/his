package cn.gson.his.controller.hzc;


import cn.gson.his.model.pojos.hzc.HospitalRegisterEntity;
import cn.gson.his.model.service.hzc.HospitalRegisterService;
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
    public int demo(@RequestBody String hospitalRegisterEntity,@RequestParam String hospitalNo){
        System.out.println("2222222222222"+hospitalNo);
        System.out.println("11111111111111"+hospitalRegisterEntity);
        HospitalRegisterEntity HospReg = JSONObject.parseObject(hospitalRegisterEntity, HospitalRegisterEntity.class);
        System.out.println("11111111111111"+HospReg);
        int i = reg.insertReg(HospReg);
        if(i>0){
            return 1;
        }
        return 0;
    }

    //查询所有住院登记表
    @RequestMapping("/selReg")
    public List<HospitalRegisterEntity> demo1(){
        return reg.selReg();
    }

}
