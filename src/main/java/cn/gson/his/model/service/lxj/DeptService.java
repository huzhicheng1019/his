package cn.gson.his.model.service.lxj;

import cn.gson.his.model.dao.lxj.DeptDao;
import cn.gson.his.model.pojos.lxj.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(rollbackFor = Exception.class)
@Service
public class DeptService {

    @Autowired
    DeptDao dao;

    /**
     * 分页查询所有
     * @param pageNo
     * @param size
     * @return
     */
    public Map<String,Object> allDept(Integer pageNo, Integer size){
        Map<String,Object> map = new HashMap<>();

        Page<Dept> page=dao.findAllBy(PageRequest.of(pageNo-1,size));

        map.put("rows",page.iterator());
        //System.out.println(page.getSize());
        map.put("total",page.getTotalElements());
        return map;
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    public Dept addDept(Dept dept) {
       Dept dept1=dao.save(dept);
       return dept1;
    }

    /**
     * 查询所有
     * @return
     */
    public List<Dept> allDept(){
        return dao.findAllBy();
    }
}