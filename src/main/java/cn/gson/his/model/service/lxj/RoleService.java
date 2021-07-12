package cn.gson.his.model.service.lxj;

import cn.gson.his.model.mappers.lxj.RoleMapper;
import cn.gson.his.model.pojos.lxj.Dept;
import cn.gson.his.model.pojos.lxj.RoleInfo;
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
public class RoleService {

    @Autowired
    RoleMapper mapper;

    /**
     * 分页查询所有
     * @param pageNo
     * @param size
     * @return
     */
    public Map<String, Object> allRole(Integer pageNo,Integer size){
        Page<Object> p = PageHelper.startPage(pageNo,size);
        List<Map<String,Object>> list = mapper.allRole();
        Map<String,Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",p.getTotal());
        return map;
    }

    public List<Dept> allRoleDept(Integer id){
        return mapper.allRoleDept(id);
    }

    public List<RoleInfo> allRoleMy(){
        return mapper.allRoleMy();
    }
}
