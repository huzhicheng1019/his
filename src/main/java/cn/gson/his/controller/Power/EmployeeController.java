package cn.gson.his.controller.Power;


import cn.gson.his.model.pojos.Power.Employee;
import cn.gson.his.model.service.Power.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/lxj")
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService empService;

    //查询住院部的医生
    @RequestMapping("selDoctor")
    public List<Employee> demo(Integer depaId){
        return  empService.selDoctor(depaId);
    }


}
