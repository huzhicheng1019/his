package cn.gson.his.controller.Power;

import cn.gson.his.model.pojos.Power.*;
import cn.gson.his.model.service.Power.RoleService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lxj")
public class RoleController {

    @Autowired
    RoleService service;

    /**
     * 分页查询所有角色
     * @return
     */
    @RequestMapping("/allRole")
    public List<RoleInfo> allRole(@RequestParam("li") String li){
        JSONObject o= JSONObject.parseObject(li);//转换Object
        String zhi=o.get("date")+"";
        Timestamp start=null;
        Timestamp end=null;
        if(zhi!=null && !("".equals(zhi))){
            String date[] = zhi.split(",");
            start=new Timestamp(new Date(Date.parse(date[0])).getTime());
            end=new Timestamp(new Date(Date.parse(date[1])).getTime());
        }
        String name=o.get("fuzzy")+"";
        return service.allRole(name,start,end);
    }

    /**
     * 查询角色、部门中间表，根据中间表的角色id查询所有部门
     * @param id
     * @return
     */
    @RequestMapping("/allRoleDept")
    public List<Dept> allRoleDept(Integer id){
        return service.allRoleDept(id);
    }

    /**
     * 查询所有角色
     * @return
     */
    @RequestMapping("/allRoleMy")
    public List<RoleInfo> allRoleMy(){
        return service.allRoleMy();
    }

    /**
     * 新增、修改角色
     * @param roleInfo
     * @return
     */
    @PostMapping("/addRole")
    public ElMessage addRole(@RequestBody RoleInfo roleInfo){
        //创建时间
        if(roleInfo.getRoleCreate()==null){
            roleInfo.setRoleCreate(new Timestamp(new Date().getTime()));
        }
        return service.addRole(roleInfo);
    }

    //级联删除角色
    @PostMapping("/delRole")
    public ElMessage delRole(@RequestBody JSONArray choose){
        int p=service.delRole(choose);
        ElMessage elm=new ElMessage();
        if(p>0){
            elm.setType("success");
            elm.setMessage("批量删除角色成功！");
        }
        return elm;
    }

    /**
     *根据角色id查询角色、权限中间表的权限id
     * @param roleId
     * @return
     */
    @RequestMapping("/allRoleIdPermId")
    public List<Integer> allRoleIdPermId(Integer roleId){
        return service.allRoleIdPermId(roleId);
    }

    /**
     * 新增角色、权限中间表
     * @param grant
     */
    @PostMapping("/addRolePerm")
    public ElMessage addRolePerm(@RequestParam("grant") String grant){
        JSONObject o = JSONObject.parseObject(grant);
        Integer roleId = Integer.parseInt(o.get("roleId").toString());
        List<Integer> funs = JSONArray.parseArray(o.get("funs").toString(),Integer.TYPE);
        service.addRolePerm(roleId,funs);
        ElMessage elm=new ElMessage("成功授权！","success");
        return elm;
    }

    @RequestMapping("/Perm-list")
    public List<Perm> allFuns(){
        return service.allFuns();
    }
}
