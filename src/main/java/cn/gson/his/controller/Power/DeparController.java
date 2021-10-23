package cn.gson.his.controller.Power;

import cn.gson.his.model.pojos.Power.Department;
import cn.gson.his.model.pojos.Power.Dept;
import cn.gson.his.model.pojos.Power.ElMessage;
import cn.gson.his.model.service.Power.DeparService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Department> allDept(@RequestParam("li")String li){
        System.out.println("值"+li);
        JSONObject o= JSONObject.parseObject(li);//转换Object
        String zhi=o.get("date")+"";
        Timestamp start=null;
        Timestamp end=null;
        if(zhi!=null && !("".equals(zhi)) && !("null".equals(zhi))){
            String date[] = zhi.split(",");
            start=new Timestamp(new Date(Date.parse(date[0])).getTime());
            end=new Timestamp(new Date(Date.parse(date[1])).getTime());
        }
        String name=o.get("idOrnameOradd")+"";
        return service.allDepar(name,start,end);
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

    @RequestMapping("/allDeptIdDepar")
    public List<Department> allDeptIdDepar(@RequestParam("id") Integer id){
        return service.allDeptIdDepar(id);
    }



}
