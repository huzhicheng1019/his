package cn.gson.his.model.service.lxj;

import cn.gson.his.model.dao.lxj.DeparDao;
import cn.gson.his.model.mappers.lxj.DeparMapper;
import cn.gson.his.model.pojos.lxj.Department;
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

    public Department addDepar(Department department){
        Department department1=dao.save(department);
        return department1;
    }

    @Autowired
    DeparMapper deparMapper;

    public List<Department> allDeparmy(){
        return deparMapper.allDepar();
    }
}
