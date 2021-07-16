package cn.gson.his.controller.Power;


import cn.gson.his.model.pojos.Power.ElMessage;
import cn.gson.his.model.pojos.Power.Employee;
import cn.gson.his.model.service.Power.EmployeeService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/addEmp")
    public ElMessage addEmp(@RequestBody Employee emp){
        int p=empService.addEmp(emp);
        ElMessage elm=new ElMessage();
        if(p>0){
            elm.setType("success");
            elm.setMessage("员工新增成功！");
        }
        return elm;
    }

    @PostMapping("/quitEmp")
    public ElMessage quitEmp(@RequestBody JSONArray choose) {
        int p = empService.quitEmp(choose,0);
        ElMessage elm=new ElMessage();
        if(p>0){
            elm.setType("success");
            elm.setMessage("员工离职成功！");
        }
        return elm;
    }

}
