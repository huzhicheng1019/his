package cn.gson.his.model.service.Power;

import cn.gson.his.model.dao.Power.DeptDao;
import cn.gson.his.model.mappers.Power.DeptMapper;
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

@Transactional(rollbackFor = Exception.class)
@Service
public class DeptService {

    @Autowired
    DeptDao dao;

    @Autowired
    DeptMapper mapper;

    /**
     * 分页查询所有
     * @param pageNo
     * @param size
     * @return
     */
    /*public Map<String,Object> allDept(Integer pageNo, Integer size){
        Map<String,Object> map = new HashMap<>();

        Page<Dept> page=dao.findAllBy(PageRequest.of(pageNo-1,size));

        map.put("rows",page.iterator());
        //System.out.println(page.getSize());
        map.put("total",page.getTotalElements());
        return map;
    }*/

    public Map<String, Object> allDept(Integer pageNo, Integer size, Dept dept, Timestamp startDate,Timestamp endDate){
        Page<Object> p = PageHelper.startPage(pageNo,size);
        List<Map<String, Object>> list = mapper.allDept(dept,startDate,endDate);
        Map<String, Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",p.getTotal());
        return map;
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    public int addDept(Dept dept) {
       Dept dept1=dao.save(dept);
       return dept1==null ? 0:1;
    }

    /**
     * 查询所有
     * @return
     */
    public List<Dept> allDept(){
        return dao.findAllBy();
    }

    /**
     * 多对多查询某角色下所有的部门
     * @param id
     * @return
     */
    public List<Dept> allRoleIdDept(Integer id) {
        return dao.allRoleIdDept(id);
    }
}
