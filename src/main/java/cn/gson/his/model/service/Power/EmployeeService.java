package cn.gson.his.model.service.Power;

import cn.gson.his.model.dao.Power.EmployeeDao;
import cn.gson.his.model.mappers.Power.EmployeeMapper;
import cn.gson.his.model.pojos.Power.Dept;
import cn.gson.his.model.pojos.Power.Employee;
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

}
