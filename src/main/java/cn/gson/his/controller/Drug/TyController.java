package cn.gson.his.controller.Drug;

import cn.gson.his.model.service.Drug.TyService;
import cn.gson.his.model.service.Drug.YfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class TyController {
    @Autowired
    TyService tyService;

    @RequestMapping("tygl")
    public Map<String,Object> getty(Integer pageNo, Integer size, String nr){
        System.out.println("nr:"+nr);
        Map<String, Object> stringObjectMap = tyService.tyselect(pageNo,size,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("tyxq")
    public Map<String,Object> gettyxq(Integer pageNo, Integer size,String id,String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = tyService.tyxqselect(pageNo,size,id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }
}
