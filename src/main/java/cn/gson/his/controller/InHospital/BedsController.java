package cn.gson.his.controller.InHospital;

import cn.gson.his.model.pojos.InHospital.BedsEntity;
import cn.gson.his.model.service.InHospital.BedsService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class BedsController {
    @Autowired
    BedsService bedsService;

    //新增床位使用记录
    @RequestMapping("insertBeds")
    public int demo(String bedsEntity){
        BedsEntity bedsEntity1 = JSONObject.parseObject(bedsEntity, BedsEntity.class);
        int i = bedsService.insertBeds(bedsEntity1);
        if(i>0){
            return 1;
        }
        return 0;
    }
    //新增床位使用记录
    @RequestMapping("insertBedsOne")
    public int demo2(String bedsEntityOne){
        BedsEntity bedsEntity1 = JSONObject.parseObject(bedsEntityOne, BedsEntity.class);
        System.out.println("新增"+bedsEntity1.toString());
        int i = bedsService.insertBedsOne(bedsEntity1);
        if(i>0){
            return 1;
        }
        return 0;
    }

    //修改床位使用记录
    @RequestMapping("updateBeds")
    public int demo1(String bedsEntity){
        BedsEntity bedsEntity1 = JSONObject.parseObject(bedsEntity, BedsEntity.class);
        System.out.println("修改"+bedsEntity1);
        int i = bedsService.updateBeds(bedsEntity1);
        if(i>0){
            return 1;
        }
        return 0;
    }

    //修改床位护士
    @RequestMapping("updateNurse")
    public int demo3(String bedsEntity){
        BedsEntity bedsEntity1 = JSONObject.parseObject(bedsEntity, BedsEntity.class);

        System.out.println("修改护士"+bedsEntity1);

        int i = bedsService.updateNurse(bedsEntity1);
        if(i>0){
            return 1;
        }
        return 0;
    }
}
