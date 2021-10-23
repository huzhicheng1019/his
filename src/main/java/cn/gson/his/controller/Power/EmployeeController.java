package cn.gson.his.controller.Power;


import cn.gson.his.model.pojos.Power.*;
import cn.gson.his.model.pojos.Power.vo.ScreeningVo;
import cn.gson.his.model.service.Power.EmployeeService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
    //查询住院部的医生
    @RequestMapping("selNurse")
    public List<Employee> demo1(Integer depaId){
        return  empService.selNurse(depaId);
    }



    /**
     * 分页查询所有
     * @param pageNo
     * @param size
     * @return
     */
    @RequestMapping("/allEmp")
    public Map<String, Object> allEmp(Integer pageNo, Integer size, @RequestParam("li")String li){
        System.out.println("筛选"+li);
        JSONObject o= JSONObject.parseObject(li);//转换Object
        String zhi=o.get("date")+"";
        Timestamp start=null;
        Timestamp end=null;
        if(zhi!=null && !("".equals(zhi)) && !("null".equals(zhi))){
            String date[] = zhi.split(",");
            start=new Timestamp(new Date(Date.parse(date[0])).getTime());
            end=new Timestamp(new Date(Date.parse(date[1])).getTime());
        }
        Integer state = Integer.parseInt(o.get("state")+"")==-1 ? null:Integer.parseInt(o.get("state")+"");
        String s=o.get("screening")+"";
        List<Integer> screening=new ArrayList<>();
        if(s!=null && !("".equals(s)) && !("null".equals(s))){
            String[] d= s.split(",");
            //System.out.println("长度"+d.length);
            for(int i=0;i<d.length;i++){
                //System.out.println("遍历数组值"+d[i]);
                screening.add(Integer.parseInt(d[i]));
            }
        }
        if(screening.isEmpty()){
            screening=null;
        }
        System.out.println("集合"+screening);
        String fuzzy=o.get("fuzzy")+"";
        return empService.allEmp(pageNo,size,start,end,state,screening,fuzzy);
    }

    @PostMapping("/addEmp")
    public ElMessage addEmp(@RequestBody Employee emp) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println("科室"+emp.getDepartmentByEmpDepar());
        //生成当前时间
        if(emp.getEmpInduction()==null){
            emp.setEmpInduction(new Timestamp(new Date().getTime()));
        }
        boolean is=emp.getEmpId()==null ? true:false;
        System.out.println("科室"+emp.getDepartmentByEmpDepar());
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
        int p = empService.quitEmp(choose);
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
    public List<Perm> home_menus(Integer userId, HttpSession session){
        return empService.homeMenu(userId);
    }

    @RequestMapping("/allTitle")
    public List<ScreeningVo> allTitle(){
        return empService.allTitle();
    }

    @RequestMapping("/allDepts")
    public List<ScreeningVo> allDept(){
        return empService.allDept();
    }

    @RequestMapping("/allDepa")
    public List<ScreeningVo> allDepa(){
        return empService.allDepa();
    }

}
