package cn.gson.his.model.service.Power;

import cn.gson.his.model.dao.Power.DeparDao;
import cn.gson.his.model.mappers.Power.DeparMapper;
import cn.gson.his.model.pojos.Power.Department;
import cn.gson.his.model.pojos.Power.Dept;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeparService {

    @Autowired
    DeparDao dao;

    @Autowired
    DeparMapper mapper;

    /**
     * 分页查询所有
     * @return
     */
    public List<Department> allDepar(String name, Timestamp startDate, Timestamp endDate){
        List<Department>list = mapper.pageDepar(name,startDate,endDate);
        return list;
    }

    /**
     * 新增、修改科室
     * @param department
     * @return
     */
    public int addDepar(Department department){
       Department department1=dao.save(department);
       return department1==null ? 0:1;
    }

    @Autowired
    DeparMapper deparMapper;

    /**
     * 查询所有
     * @return
     */
    public List<Department> allDeparmy(){
        return deparMapper.allDepar();
    }
    //查询所有门诊的科室
    public List<Department> allDepar1(){
        return deparMapper.allDepar1();
    }
    //查询所有住院的科室
    public List<Department> allDepar2(){
        return deparMapper.allDepar2();
    }
    /**
     * 根据部门id查询该部门的科室
     * @param id
     * @return
     */
    public List<Department> allDeptIdDepar(Integer id) {
        return dao.findAllByDept_DeptId(id);
    }
}
