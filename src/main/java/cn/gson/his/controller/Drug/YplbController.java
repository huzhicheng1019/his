package cn.gson.his.controller.llw;

import cn.gson.his.model.pojos.llw.DrugEntity;
import cn.gson.his.model.pojos.llw.LbEntity;
import cn.gson.his.model.service.llw.YplbService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class YplbController {
    @Autowired
    YplbService yplbService;

    @RequestMapping("yplb")
    public Map<String,Object> getYplb(Integer pageNo, Integer size,String lb){
        System.out.println(pageNo+"'"+size);
        LbEntity lbEntity = JSONObject.parseObject(lb, LbEntity.class);
        Map<String, Object> stringObjectMap = yplbService.lbcx(pageNo,size,lbEntity);
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
            List<DrugEntity> ypcx = yplbService.ypcx(id);
            if(ypcx.size()>0){
                return "该药品类别不可删除";
            }else {
                yplbService.del(id);
                return "ok";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
