package cn.gson.his.model.service.lxj;

import cn.gson.his.model.mappers.lxj.EmployeeMapper;
import cn.gson.his.model.pojos.lxj.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeService {
    @Autowired
    EmployeeMapper empMapper;

    public List<Employee> selDoctor(Integer depaId){
        return empMapper.selDoctor(depaId);
    }

}
