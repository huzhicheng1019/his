package cn.gson.his.model.mappers.Power;


import cn.gson.his.model.pojos.Power.*;
import cn.gson.his.model.pojos.Power.vo.ScreeningVo;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper {

    //查询住院部的医生
    public List<Employee> selDoctor(Integer depaId);
    //查询住院部某科室的护士
    public List<Employee> selNurse(Integer depaId);

    /**
     * 分页查询所有
     * @return
     */
    public List<Map<String,Object>> allEmp(@Param("start") Timestamp start,@Param("end") Timestamp end,@Param("state") Integer state,@Param("screening") List<Integer> screening,@Param("fuzzy") String fuzzy);

    /**
     * 离职员工
     * @param choose
     * @return
     */
    public int quitEmp(@Param("choose") JSONArray choose);

    /**
     * 根据用户id查询角色id
     * @param userId
     * @return
     */
    public List<Integer> allEmpRole(Integer userId);

    /**
     * 查询角色
     * @return
     */
    public List<RoleInfo> allRole();

    public List<Perm> homeMenu(Integer userId);

    List<ScreeningVo> allTitle();

    List<ScreeningVo> allDept();

    List<ScreeningVo> allDepa();

    public List<RoleInfo> childrenRole(Integer roleId);
}
