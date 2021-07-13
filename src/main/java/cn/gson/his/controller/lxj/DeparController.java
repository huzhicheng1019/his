package cn.gson.his.controller.lxj;

import cn.gson.his.model.pojos.lxj.Department;
import cn.gson.his.model.pojos.lxj.ElMessage;
import cn.gson.his.model.service.lxj.DeparService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/lxj")
@RestController
public class DeparController {
    @Autowired
    DeparService service;

    /**
     * 分页查询所有
     * @param pageNo
     * @param size
     * @return
     */
    @RequestMapping("/allDepar")
    public Map<String, Object> allDept(Integer pageNo, Integer size){
        return service.allDepar(pageNo,size);
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/allDeparmy")
    public List<Department> allDept(){
        return service.allDeparmy();
    }

    /**
     * 新增、修改部门
     * @param department
     * @return
     */
    @PostMapping("/addDepar")
    public ElMessage addDepar(@RequestBody Department department){
        //当前时间生成
        if(department.getDepaCreate()==null){
            department.setDepaCreate(new Timestamp(new Date().getTime()));
        }
        //返回结果信息
        ElMessage elm=new ElMessage();
        if(department.getDepaId()==null || department.getDepaId().equals("")){
            elm.setMessage("科室新增成功");
        }else{
            elm.setMessage("科室修改成功");
        }
        int p=service.addDepar(department);
        if(p>0){
            elm.setType("success");
        }else{
            elm.setType("error");
            elm.setMessage("更新数据失败！");
        }
        return elm;

    }





}
