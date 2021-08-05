package cn.gson.his.controller.Drug;

import cn.gson.his.model.service.Drug.DbsqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class DbsqController {
    @Autowired
    DbsqService dbsqService;

    @RequestMapping("dbgl")
    public Map<String,Object> getck(Integer pageNo, Integer size, String nr){
        System.out.println("nr:"+nr);
        Map<String, Object> stringObjectMap = dbsqService.dbselect(pageNo,size,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("dbxq")
    public Map<String,Object> getckxq(Integer pageNo, Integer size,Integer id,String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = dbsqService.dbxqselect(pageNo,size,id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("dbckxq")
    public Map<String,Object> getdbckxq(Integer id,String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = dbsqService.dbckxqcx(id,nr);
        return stringObjectMap;
    }
}
