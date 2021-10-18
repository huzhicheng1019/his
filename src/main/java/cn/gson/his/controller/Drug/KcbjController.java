package cn.gson.his.controller.Drug;

import cn.gson.his.model.service.Drug.KcbjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class KcbjController {
    @Autowired
    KcbjService kcbjService;

    @RequestMapping("kcbj")
    public Map<String,Object> getkcbj(){
        Map<String, Object> stringObjectMap = kcbjService.kcbjcx();
        return stringObjectMap;
    }
}
