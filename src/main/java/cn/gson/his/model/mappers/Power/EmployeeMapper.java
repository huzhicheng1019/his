package cn.gson.his.model.mappers.Power;


import cn.gson.his.model.pojos.Power.Employee;
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

    public int quitEmp(@Param("state") Integer state,@Param("choose") JSONArray choose);

}
