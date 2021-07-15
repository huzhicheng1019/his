package cn.gson.his.controller.lxj;

import cn.gson.his.model.pojos.lxj.Dept;
import cn.gson.his.model.pojos.lxj.ElMessage;
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
    public ElMessage addDept(@RequestBody Dept dept){
        //生成当前时间
        if(dept.getDeptCreate()==null){
            dept.setDeptCreate(new Timestamp(new Date().getTime()));
        }

        //返回结果信息
        ElMessage elm=new ElMessage();
        if(dept.getDeptId()==null || dept.getDeptId().equals("")){
            elm.setMessage("部门新增成功！");
        }else{
            elm.setMessage("部门修改成功！");
        }
        int p=ser.addDept(dept);
        if(p>0){
            elm.setType("success");
        }else{
            elm.setType("error");
            elm.setMessage("更新数据失败");
        }
        return elm;
    }

    /**
     * 查询所有部门
     * @return
     */
    @RequestMapping("/findDept")
    public List<Dept> allDept(){
        return ser.allDept();
    }

    /**
     * 多对多查询某角色下所有的部门
     * @param id
     * @return
     */
    @RequestMapping("/allRoleIdDept")
    public List<Dept> allRoleIdDept(Integer id){
        return ser.allRoleIdDept(id);
    }
}
