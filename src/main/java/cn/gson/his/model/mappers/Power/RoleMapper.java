package cn.gson.his.model.mappers.lxj;

import cn.gson.his.model.pojos.lxj.Dept;
import cn.gson.his.model.pojos.lxj.Perm;
import cn.gson.his.model.pojos.lxj.RoleDeptPK;
import cn.gson.his.model.pojos.lxj.RoleInfo;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {

    /**
     * 分页查询所有角色
     * @return
     */
    public List<Map<String,Object>> allRole();

    /**
     * 查询角色、部门中间表，根据中间表的角色id查询所有部门
     * @param id
     * @return
     */
    public List<Dept> allRoleDept(Integer id);

    /**
     * 查询所有角色
     * @return
     */
    public List<RoleInfo> allRoleMy();

    //查询序列
    public Integer allSeq();

    //新增角色表
    public int addRole(@Param("roleid") Integer roleid,@Param("name") String name,@Param("create") Timestamp create, @Param("id") Integer id);

    //新增角色部门中间表
    public int addRoleDept(List<RoleDeptPK> list);

    /**
     * 级联删除角色
     * @param choose
     * @return
     */
    public int delRole(@Param("choose") JSONArray choose);

    /**
     * 修改角色
     * @param roleId
     * @param roleName
     * @param id
     * @return
     */
    public int updateRole(@Param("roleId") Integer roleId,@Param("roleName") String roleName,@Param("id") Integer id);

    /**
     * 根据角色id删除角色、部门中间表
     * @param roleId
     * @return
     */
    public int delRoleDept(@Param("roleId") Integer roleId);

    /**
     * 根据角色id查询角色、权限中间表的权限id
     * @param roleId
     * @return
     */
    public List<Integer> allRoleIdPermId(Integer roleId);

    public List<Perm> allPerm();

    public List<Perm> childrenFuns(Integer parentId);

    public int addRolenoParent(RoleInfo roleInfo);
}
