package cn.gson.his.controller.lxj;

import cn.gson.his.model.pojos.lxj.Dept;
import cn.gson.his.model.service.lxj.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RequestMapping("/lxj")
@RestController
public class DeptController {

    @Autowired
    DeptService ser;

    @GetMapping("/allDept")
    public Map<String, Object> allDept(Integer pageNo, Integer size){
        return ser.allDept(pageNo,size);
    }

    @PostMapping("/addDept")
    public String addDept(@RequestBody Dept dept){
        Dept de=ser.addDept(dept);
        if(de==null){
            return "flia";
        }
        return "ok";
    }

}
