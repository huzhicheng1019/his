package cn.gson.his.model.service.Power;

import cn.gson.his.model.mappers.Power.EmployeeMapper;
import cn.gson.his.model.pojos.Power.Employee;
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
