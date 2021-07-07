package cn.gson.his.controller.llw;

import cn.gson.his.model.service.llw.YpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController
public class Ypgl {
    @Autowired
    YpService ypService;

    @RequestMapping("ypgl")
    public Map<String,Object> getEmps(Integer pageNo, Integer size){
        System.out.println(pageNo+"'"+size);
        Map<String, Object> stringObjectMap = ypService.ypselect(pageNo,size);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }
}
