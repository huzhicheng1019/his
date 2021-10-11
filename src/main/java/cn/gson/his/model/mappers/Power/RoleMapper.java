package cn.gson.his.model.mappers.Power;

import cn.gson.his.model.pojos.Power.Dept;
import cn.gson.his.model.pojos.Power.Perm;
import cn.gson.his.model.pojos.Power.RoleInfo;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface RoleMapper {

    /**
     * 分页查询所有角色
     * @return
     */
    public List<RoleInfo> allRole(@Param("name") String name,@Param("start") Timestamp start,@Param("end") Timestamp end);

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

    /**
     * 删除角色
     * @param choose
     * @return
     */
    public int delRole(@Param("choose") JSONArray choose);

    public int delEmpRole(@Param("choose") JSONArray choose);

    public int delRolePerm(@Param("choose") JSONArray choose);


    public int updateRole(RoleInfo roleInfo);

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
