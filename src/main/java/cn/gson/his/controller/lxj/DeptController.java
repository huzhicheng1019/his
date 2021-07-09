package cn.gson.his.controller.lxj;

import cn.gson.his.model.pojos.lxj.Dept;
import cn.gson.his.model.service.lxj.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/lxj")
@RestController
public class DeptController {

    @Autowired
    DeptService ser;

    /**
     * 分页查询所有
     * @param pageNo
     * @param size
     * @return
     */
    @GetMapping("/allDept")
    public Map<String, Object> allDept(Integer pageNo, Integer size){
        return ser.allDept(pageNo,size);
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    @PostMapping("/addDept")
    public String addDept(@RequestBody Dept dept){
        if(dept.getDeptCreate()==null){
            dept.setDeptCreate(new Timestamp(new Date().getTime()));
        }
        Dept dept1=ser.addDept(dept);
        if(dept1==null){
            return "fail";
        }
        return "ok";
    }

    @RequestMapping("/findDept")
    public List<Dept> allDept(){
        return ser.allDept();
    }

}
