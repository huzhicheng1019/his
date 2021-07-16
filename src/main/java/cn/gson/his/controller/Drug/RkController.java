package cn.gson.his.controller.Drug;

import cn.gson.his.model.service.Drug.RkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class RkController {
    @Autowired
    RkService rkService;

    @RequestMapping("rkgl")
    public Map<String,Object> getck(Integer pageNo, Integer size,String why, String nr){
        System.out.println("nr:"+nr);
        Map<String, Object> stringObjectMap = rkService.rkcx(pageNo,size,why,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }
}
