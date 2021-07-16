package cn.gson.his.model.service.Power;

import cn.gson.his.model.dao.Power.DeparDao;
import cn.gson.his.model.mappers.Power.DeparMapper;
import cn.gson.his.model.pojos.Power.Department;
import cn.gson.his.model.pojos.Power.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeparService {

    @Autowired
    DeparDao dao;

    /**
     * 分页查询所有
     * @param pageNo
     * @param size
     * @return
     */
    public Map<String,Object> allDepar(Integer pageNo, Integer size){
        Map<String,Object> map = new HashMap<>();

        Page<Department> page=dao.findAllBy(PageRequest.of(pageNo-1,size));

        map.put("rows",page.iterator());
        //System.out.println(page.getSize());
        map.put("total",page.getTotalElements());
        return map;
    }

    /**
     * 新增、修改科室
     * @param department
     * @return
     */
    public int addDepar(Department department){
       Department department1=dao.save(department);
       if(department1==null){
           new RuntimeException("更新数据失败");
           return 0;
       }
       return 1;
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

    /**
     * 根据部门id查询该部门的科室
     * @param id
     * @return
     */
    public List<Department> allDeptIdDepar(Integer id) {
        return dao.findAllByDept_DeptId(id);
    }
}
