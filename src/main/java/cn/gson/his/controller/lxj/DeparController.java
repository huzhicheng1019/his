package cn.gson.his.controller.lxj;

import cn.gson.his.model.pojos.lxj.Department;
import cn.gson.his.model.service.lxj.DeparService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/lxj")
@RestController
public class DeparController {
    @Autowired
    DeparService service;

    @RequestMapping("/allDepar")
    public Map<String, Object> allDept(Integer pageNo, Integer size){
        return service.allDepar(pageNo,size);
    }

    @RequestMapping("/allDeparmy")
    public List<Department> allDept(){
        return service.allDeparmy();
    }

}
