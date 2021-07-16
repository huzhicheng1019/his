package cn.gson.his.model.service.Power;

import cn.gson.his.model.dao.Power.EmployeeDao;
import cn.gson.his.model.dao.Power.UserDao;
import cn.gson.his.model.mappers.Power.EmployeeMapper;
import cn.gson.his.model.mappers.Power.RoleMapper;
import cn.gson.his.model.pojos.Power.Dept;
import cn.gson.his.model.pojos.Power.Employee;
import cn.gson.his.model.pojos.Power.UserInfo;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeService {
    @Autowired
    EmployeeMapper empMapper;

    @Autowired
    EmployeeDao dao;

    @Autowired
    UserDao userDao;

    @Autowired
    RoleMapper roleMapper;

    public List<Employee> selDoctor(Integer depaId){
        return empMapper.selDoctor(depaId);
    }

    /**
     * 分页查询所有
     * @param pageNo
     * @param size
     * @return
     */
    public Map<String, Object> allEmp(Integer pageNo,Integer size){
        Page<Object> p = PageHelper.startPage(pageNo,size);
        List<Map<String,Object>> list = empMapper.allEmp();
        Map<String,Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",p.getTotal());
        return map;
    }

    /**
     * 一对一新增、修改员工、用户
     * @param emp
     * @return
     */
    public int addEmp(Employee emp){
        Integer id=roleMapper.allSeq();
        emp.getUseres().setUserId(id);
        Employee s = dao.save(emp);
        if(s==null){
            return 0;
        }
        return 1;
    }

    public int quitEmp(JSONArray choose,Integer state) {
        int p=empMapper.quitEmp(state,choose);
        return p;
    }
}
