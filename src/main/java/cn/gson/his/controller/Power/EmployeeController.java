package cn.gson.his.controller.Power;


import cn.gson.his.model.pojos.Power.ElMessage;
import cn.gson.his.model.pojos.Power.Employee;
import cn.gson.his.model.pojos.Power.Perm;
import cn.gson.his.model.pojos.Power.RoleInfo;
import cn.gson.his.model.service.Power.EmployeeService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        //System.out.println("员工："+empService.allEmp(pageNo, size).get("rows"));
        return empService.allEmp(pageNo,size);
    }

    @PostMapping("/addEmp")
    public ElMessage addEmp(@RequestBody Employee emp){
        System.out.println("科室"+emp.getDepartmentByEmpDepar());
        boolean is=emp.getEmpId()==null ? true:false;
        int p=empService.addEmp(emp);
        ElMessage elm=new ElMessage();
        if(p>0){
            elm.setType("success");
            if(is){
                elm.setMessage("员工新增成功！");
            }else {
                //elm.setType("success");
                elm.setMessage("员工修改成功！");
            }
        }
        return elm;
    }

    @PostMapping("/quitEmp")
    public ElMessage quitEmp(@RequestBody JSONArray choose) {
        int p = empService.quitEmp(choose,1);
        ElMessage elm=new ElMessage();
        if(p>0){
            elm.setType("success");
            elm.setMessage("员工离职成功！");
        }
        return elm;
    }

    /**
     *根据角色id查询角色、权限中间表的权限id
     * @param userId
     * @return
     */
    @RequestMapping("/allEmpRole")
    public List<Integer> allRoleIdPermId(Integer userId){
        return empService.allEmpRole(userId);
    }

    /**
     * 新增角色、权限中间表
     * @param grant
     */
    @PostMapping("/addEmpRole")
    public ElMessage addRolePerm(@RequestParam("grant") String grant){
        JSONObject o = JSONObject.parseObject(grant);
        Integer userId = Integer.parseInt(o.get("userId").toString());
        List<Integer> funs = JSONArray.parseArray(o.get("funs").toString(),Integer.TYPE);
        empService.addRolePerm(userId,funs);
        ElMessage elm=new ElMessage("成功授权！","success");
        return elm;
    }

    /**
     * 查询角色
     * @return
     */
    @RequestMapping("/Role-list")
    public List<RoleInfo> allFuns(){
        return empService.allRole();
    }

    @RequestMapping("/home-menus")
    public List<Perm> home_menus(Integer userId){
        return empService.homeMenu(userId);
    }

}
