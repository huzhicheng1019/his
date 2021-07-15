package cn.gson.his.controller.Power;


import cn.gson.his.model.pojos.Power.Employee;
import cn.gson.his.model.service.Power.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    /**
     * 分页查询所有
     * @param pageNo
     * @param size
     * @return
     */
    @RequestMapping("/allEmp")
    public Map<String,Object> allEmp(Integer pageNo, Integer size){
        System.out.println("员工："+empService.allEmp(pageNo, size).get("rows"));
        return empService.allEmp(pageNo,size);
    }


}
