package cn.gson.his.controller.lxj;

import cn.gson.his.model.pojos.lxj.Department;
import cn.gson.his.model.service.lxj.DeparService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/lxj")
@RestController
public class DeparController {
    @Autowired
    DeparService service;

    /**
     * 分页查询所有
     * @param pageNo
     * @param size
     * @return
     */
    @RequestMapping("/allDepar")
    public Map<String, Object> allDept(Integer pageNo, Integer size){
        return service.allDepar(pageNo,size);
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/allDeparmy")
    public List<Department> allDept(){
        return service.allDeparmy();
    }

    @PostMapping("/addDepar")
    public String addDepar(@RequestBody Department department){
        if(department.getDepaCreate()==null){
            department.setDepaCreate(new Timestamp(new Date().getTime()));
        }
        Department department1 = service.addDepar(department);
        if(department1==null){
            return "fail";
        }
        return "ok";
    }





}
