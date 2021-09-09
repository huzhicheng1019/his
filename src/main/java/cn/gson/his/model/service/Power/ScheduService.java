package cn.gson.his.model.service.Power;

import cn.gson.his.model.dao.Power.ScheduDao;
import cn.gson.his.model.mappers.Power.ScheduMapper;
import cn.gson.his.model.pojos.Power.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class ScheduService {

    @Autowired
    ScheduDao dao;

    @Autowired
    ScheduMapper mapper;

    /**
     * 根据部门查询科室
     * @param name
     * @return
     */
    /*public List<Department> deptIdByDepaByTit(String name){
        Integer id=mapper.allDeptId(name);
        List<Department> depas= mapper.deptIdDepa(id);
        return depas;
    }

    *//**
     * 根据部门和科室查询员工
     * @param name
     * @param depa
     * @return
     *//*
    public List<Employee> depaIdByEmp(String name,Integer depa){
        Integer id=mapper.allDeptId(name);
        List<Employee> emp=mapper.depaIdByEmp(id,depa);
        return emp;
    }

    *//**
     * 查询所有班次
     * @return
     *//*
    public List<Shift> allShift(){
        return mapper.allShift();
    }

    *//**
     * 新增排班
     * @param list
     * @return
     *//*
    public int addSchedu(List<Schedu> list){
        return mapper.addSchedu(list);
    }

    *//**
     * 查询排班
     * @param pageNo
     * @param size
     * @param dept
     * @return
     *//*
    public Map<String, Object> allSche(Integer pageNo, Integer size, String dept) {
        Page<Object> p = PageHelper.startPage(pageNo,size);
        List<Map<String,Object>> list = mapper.allSche(dept);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",p.getTotal());
        return map;
    }
*/

    /**
     * 根据班次类型查询班次
     * @param typeId
     * @return
     */
    public List<Shift> allShiftById(Integer typeId) {
        return mapper.allShiftById(typeId);
    }

    public List<Schedu> allScheEmp(){
        return mapper.allScheEmp();
    }
}
