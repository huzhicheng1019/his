package cn.gson.his.controller.lxj;

import cn.gson.his.model.pojos.lxj.Dept;
import cn.gson.his.model.pojos.lxj.RoleInfo;
import cn.gson.his.model.service.lxj.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lxj")
public class RoleController {

    @Autowired
    RoleService service;

    @RequestMapping("/allRole")
    public Map<String, Object> allRole(Integer pageNo,Integer size){
        return service.allRole(pageNo,size);
    }

    @RequestMapping("/allRoleDept")
    public List<Dept> allRoleDept(Integer id){
        return service.allRoleDept(id);
    }
}
