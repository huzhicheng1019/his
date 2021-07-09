package cn.gson.his.controller.llw;

import cn.gson.his.model.pojos.llw.DrugEntity;
import cn.gson.his.model.pojos.wjc.PatientdataEntity;
import cn.gson.his.model.service.llw.YpService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class Ypgl {
    @Autowired
    YpService ypService;

    @RequestMapping("ypgl")
    public Map<String,Object> getYp(Integer pageNo, Integer size,String form){
        System.out.println(form);
        DrugEntity drugEntity= JSONObject.parseObject(form,DrugEntity.class);
        Map<String, Object> stringObjectMap = ypService.ypselect(pageNo,size,drugEntity);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("add-yp")
    public String ypxz(@RequestBody DrugEntity form){
        try {
            ypService.saveYp(form);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("del-yp")
    public String delyp(Integer id){
        System.out.println(id);
        try {
            ypService.del(id);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
