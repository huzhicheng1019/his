package cn.gson.his.controller.lxj;

import cn.gson.his.model.pojos.lxj.Dept;
import cn.gson.his.model.pojos.lxj.ElMessage;
import cn.gson.his.model.pojos.lxj.RoleDeptPK;
import cn.gson.his.model.pojos.lxj.RoleInfo;
import cn.gson.his.model.service.lxj.RoleService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param pageNo
     * @param size
     * @return
     */
    @RequestMapping("/allRole")
    public Map<String, Object> allRole(Integer pageNo,Integer size){
        return service.allRole(pageNo,size);
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
        int id=-1;//接收角色id
        boolean is=false;//判断修改还是新增：false为新增，true为修改
        ElMessage elm=new ElMessage();
        if(roleInfo.getRoleId()!=null && !roleInfo.getRoleId().equals("")){//如果前端传过来的id不为空，则是修改
            id=roleInfo.getRoleId();//获取角色id
            is=true;//改变状态
            elm.setMessage("角色修改成功！");
        }else{
            //新增通过查询序列来赋值角色id
            id=service.allSeq();
            roleInfo.setRoleId(id);
            elm.setMessage("角色新增成功！");
        }
        //新增集合，用于批量新增角色、部门中间表
        List<RoleDeptPK> list=new ArrayList<>();
        for (int i = 0; i<roleInfo.getDepts().size(); i++){
            list.add(new RoleDeptPK(id,roleInfo.getDepts().get(i).getDeptId()));
        }
        //新增角色表、批量新增角色和部门中间表
        int p=service.addRole(roleInfo,roleInfo.getRoleinfoByRoleParent().getRoleId(),list,is);
        //返回结果信息
        if(p>0){
            elm.setType("success");
        }else{
            elm.setType("error");
            elm.setMessage("更新数据失败");
        }
        return elm;
    }

    //级联删除角色
    @PostMapping("/delRole")
    public ElMessage delRole(@RequestBody JSONArray choose){
        int p=service.delRole(choose);
        ElMessage elm=new ElMessage();
        if(p>0){
            elm.setType("success");
            elm.setMessage("批量删除角色成功！");
        }else{
            elm.setType("error");
            elm.setMessage("更新数据失败！");
        }
        return elm;
    }
}
