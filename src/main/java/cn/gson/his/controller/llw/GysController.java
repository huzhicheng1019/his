package cn.gson.his.controller.llw;

import cn.gson.his.model.pojos.llw.GysEntity;
import cn.gson.his.model.pojos.llw.LbEntity;
import cn.gson.his.model.service.llw.GysService;
import cn.gson.his.model.service.llw.YplbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class GysController {
    @Autowired
    GysService gysService;

    @RequestMapping("gys")
    public Map<String,Object> getGys(Integer pageNo, Integer size){
        Map<String, Object> stringObjectMap = gysService.lbcx(pageNo,size);
        return stringObjectMap;
    }

    @RequestMapping("add-gys")
    public String gysxz(@RequestBody GysEntity gys){
        try {
            gysService.saveYplb(gys);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("del-gys")
    public String delgys(Integer id){
        System.out.println(id);
        try {
            gysService.del(id);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
