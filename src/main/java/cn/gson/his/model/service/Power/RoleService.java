package cn.gson.his.model.service.Power;

import cn.gson.his.model.dao.Power.PermDao;
import cn.gson.his.model.dao.Power.RoleDao;
import cn.gson.his.model.mappers.Power.RoleMapper;
import cn.gson.his.model.pojos.Power.*;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleService {

    @Autowired
    RoleMapper mapper;

    @Autowired
    RoleDao roleDao;

    @Autowired
    PermDao permDao;

    /**
     * 分页查询所有
     * @return
     */
    public List<RoleInfo> allRole(String name,Timestamp start, Timestamp end){
        return mapper.allRole(name,start,end);
    }

    /**
     * 查询角色、部门中间表，根据中间表的角色id查询所有部门
     * @param id
     * @return
     */
    public List<Dept> allRoleDept(Integer id){
        return mapper.allRoleDept(id);
    }

    /**
     * 查询序列
     * @return
     */
    public Integer allSeq(){
        return mapper.allSeq();
    }

    /**
     * 查询所有角色
     * @return
     */
    public List<RoleInfo> allRoleMy(){
        return mapper.allRoleMy();
    }

    /**
     * 新增、修改角色
     * @param roleInfo
     * @return
     */
    public ElMessage addRole(RoleInfo roleInfo){
        ElMessage elm=new ElMessage();
        elm.setType("success");
        int p=-1;
        System.out.println("Service角色"+roleInfo);
        System.out.println("Service父级角色"+roleInfo.getRoleinfoByRoleParent());
        if(roleInfo.getRoleId()==null){
            p=mapper.addRolenoParent(roleInfo);
            elm.setMessage("角色新增成功！");
        }else{
            p=mapper.updateRole(roleInfo);
            elm.setMessage("角色修改成功！");
        }

        if(p<0){
            elm=new ElMessage("更新数据失败","error");
        }
        return elm;
    }

    /**
     * 删除角色
     * @param choose
     * @return
     */
    public int delRole(JSONArray choose){
        mapper.delEmpRole(choose);
        mapper.delRolePerm(choose);
        return mapper.delRole(choose);
    }

    /**
     * 根据角色id查询角色、权限中间表的权限id
     * @param roleId
     * @return
     */
    public List<Integer> allRoleIdPermId(Integer roleId){
        return mapper.allRoleIdPermId(roleId);
    }

    /**
     * 新增角色、权限中间表
     * @param roleId
     * @param funs
     */
    public void addRolePerm(Integer roleId,List<Integer> funs){
        RoleInfo role = roleDao.findById(roleId).get();
        List<Perm> allById =
                (List<Perm>)permDao.findAllById(funs);

        List<Perm> functions = role.getPerms();
        if(functions == null){
            functions = new ArrayList<>();
        }
        functions.clear();//把原来的全部清空
        functions.addAll(allById);
        role.setPerms(functions);//触发中间表新增
    }


    //查一级的功能：权限管理
    public List<Perm> allFuns(){
        List<Perm> firstFuns = mapper.allPerm();
        for (Perm firstFun : firstFuns) {
            firstFun.setPermByPermParent(childrenFuns(firstFun.getPermId()));
        }
        return firstFuns;
    }

    public List<Perm> childrenFuns(Integer parentId){
        List<Perm> childrenFuns = mapper.childrenFuns(parentId);
        for (Perm cFun : childrenFuns) {
            cFun.setPermByPermParent(childrenFuns(cFun.getPermId()));
        }
        return childrenFuns;
    };
}
