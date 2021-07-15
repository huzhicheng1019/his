package cn.gson.his.controller.Drug;

import cn.gson.his.model.pojos.Drug.LbEntity;
import cn.gson.his.model.service.Drug.YplbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class YplbController {
    @Autowired
    YplbService yplbService;

    @RequestMapping("yplb")
    public Map<String,Object> getYplb(Integer pageNo, Integer size){
        System.out.println(pageNo+"'"+size);
        Map<String, Object> stringObjectMap = yplbService.lbcx(pageNo,size);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("add-yplb")
    public String yplbxz(@RequestBody LbEntity lb){
        try {
            yplbService.saveYplb(lb);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("del-yplb")
    public String delyplb(Integer id){
        System.out.println(id);
        try {
            yplbService.del(id);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
