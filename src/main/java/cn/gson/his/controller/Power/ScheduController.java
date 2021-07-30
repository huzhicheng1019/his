package cn.gson.his.controller.Power;

import cn.gson.his.model.pojos.Power.*;
import cn.gson.his.model.service.Power.ScheduService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lxj")
public class ScheduController {

    @Autowired
    ScheduService service;

    /**
     * 根据部门查询科室
     * @param name
     * @return
     */
    @RequestMapping("/deptIdByDepaByTit")
    public List<Department> deptIdByDepaByTit(String name){
        return service.deptIdByDepaByTit(name);
    }

    /**
     * 根据部门和科室查询员工
     * @param dept
     * @param depaId
     * @return
     */
    @RequestMapping("/depaEmp")
    public List<Employee> depaEmp(@RequestParam("dept") String dept, @RequestParam("depaId") Integer depaId){
        return service.depaIdByEmp(dept,depaId);
    }

    /**
     * 查询班次
     * @return
     */
    @RequestMapping("/ScheShift")
    public List<Shift> ScheShift(){
        return service.allShift();
    }

    /**
     * 新增排班
     * @param grant
     * @return
     * @throws ParseException
     */
    @PostMapping("/addSchedu")
    public ElMessage addSchedu(@RequestParam("grant") String grant) throws ParseException {
        JSONObject o= JSONObject.parseObject(grant);//转换Object
        List<String> date = JSONArray.parseArray(o.get("date").toString(), String.class);//转换数组
        List<Employee> emp = JSONArray.parseArray(o.get("emp").toString(), Employee.class);//转换数组--员工
        Shift shift= JSONObject.toJavaObject((JSON) o.get("shift"),Shift.class);//转换对象--班次
        List<String> rq=date(date.get(0),date.get(1));//日期
        List<Schedu> schedus=new ArrayList<>();
        for (int i=0;i<emp.size();i++){
            for (int j=0;j<rq.size();j++){
                schedus.add(new Schedu(emp.get(i),rq.get(j),shift.getStartTime(),shift.getStopTime()));
            }
        }
        int p=service.addSchedu(schedus);
        ElMessage elm=new ElMessage();
        if(p>0){
            elm.setType("success");
            elm.setMessage("排班成功！");
        }
        return elm;
    }

    /**
     * 遍历返回中间日期
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public List<String> date(String start,String end) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(start));
        List<String> list=new ArrayList<>();
        for (long d = cal.getTimeInMillis(); d <= sdf.parse(end).getTime(); d = get_D_Plaus_1(cal)) {
            list.add(sdf.format(d));
        }
        return list;
    }
    public long get_D_Plaus_1(Calendar c) {
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
        return c.getTimeInMillis();
    }

    @RequestMapping("/allSche")
    public Map<String,Object> allSche(Integer pageNo,Integer size,String dept){
        return service.allSche(pageNo,size,dept);
    }
}
