package cn.gson.his.model.service.Power;

import cn.gson.his.model.dao.Power.PermDao;
import cn.gson.his.model.dao.Power.RoleDao;
import cn.gson.his.model.mappers.Power.RoleMapper;
import cn.gson.his.model.pojos.Power.Dept;
import cn.gson.his.model.pojos.Power.Perm;
import cn.gson.his.model.pojos.Power.RoleDeptPK;
import cn.gson.his.model.pojos.Power.RoleInfo;
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
     * @param pageNo
     * @param size
     * @return
     */
    public Map<String, Object> allRole(Integer pageNo,Integer size){
        Page<Object> p = PageHelper.startPage(pageNo,size);
        List<Map<String,Object>> list = mapper.allRole();
        Map<String,Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",p.getTotal());
        return map;
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
     * @param list
     * @param is
     * @return
     */
    public int addRole(RoleInfo roleInfo, List<RoleDeptPK> list,boolean is){
        int p=-1;//判断新增、修改是否成功
        if(is){
            p=mapper.updateRole(roleInfo.getRoleId(),roleInfo.getRoleName(),roleInfo.getRoleinfoByRoleParent().getRoleId());//修改
            /*int t=mapper.delRoleDept(roleInfo.getRoleId());
            if(t<0){
                new RuntimeException("修改数据失败");
            }*/
        }else{
            //新增角色
            if(roleInfo.getRoleinfoByRoleParent().getRoleId()==null){
                p=mapper.addRolenoParent(roleInfo);
            }else {
                p = mapper.addRole(roleInfo.getRoleId(), roleInfo.getRoleName(), roleInfo.getRoleCreate(), roleInfo.getRoleinfoByRoleParent().getRoleId());
            }
        }
        //批量新增角色和部门中间表，可以不新增
        int k=0;
        if(list.isEmpty()){
            k=1;
        }else{
            k=mapper.addRoleDept(list);
        }
        return p>0 && k>0 ? 1:0;
    }

    /**
     * 级联删除角色
     * @param choose
     * @return
     */
    public int delRole(JSONArray choose){
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
