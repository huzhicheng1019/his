package cn.gson.his.model.mappers.Power;


import cn.gson.his.model.pojos.Power.Employee;
import cn.gson.his.model.pojos.Power.Perm;
import cn.gson.his.model.pojos.Power.RoleInfo;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper {

    //查询住院部的医生
    public List<Employee> selDoctor(Integer depaId);


    /**
     * 分页查询所有
     * @return
     */
    public List<Map<String,Object>> allEmp();

    /**
     * 离职员工
     * @param state
     * @param choose
     * @return
     */
    public int quitEmp(@Param("state") Integer state,@Param("choose") JSONArray choose);

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

    //public List<RoleInfo> childrenFuns(Integer parentId);
}
