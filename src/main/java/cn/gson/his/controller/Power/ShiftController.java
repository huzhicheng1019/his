package cn.gson.his.controller.Power;

import cn.gson.his.model.pojos.Power.ElMessage;
import cn.gson.his.model.pojos.Power.Shift;
import cn.gson.his.model.service.Power.ShiftService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lxj")
public class ShiftController {

    @Autowired
    ShiftService service;

    @RequestMapping("/allShift")
    public Map<String, Object> allShift(Integer pageNo, Integer size){
        return service.allShift(pageNo,size);
    }

    @PostMapping("/addShift")
    public ElMessage addShift(@RequestParam("grant") String grant) throws ParseException {
        JSONObject o= JSONObject.parseObject(grant);//转换Object
        Shift shift= JSONObject.toJavaObject((JSON) o.get("shift"),Shift.class);//转换对象
        List<String> date = JSONArray.parseArray(o.get("date").toString(), String.class);//转换数组
        Date date1 = UTCToCST(date.get(0), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");//国际时间转换北京时间
        Date date2 = UTCToCST(date.get(1), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");//国际时间转换北京时间
        DateFormat df = DateFormat.getTimeInstance();//只显示出时分秒
        String startTime = df.format(date1);
        String stopTime=df.format(date2);
        shift.setStartTime(startTime);
        shift.setStopTime(stopTime);

        boolean is=shift.getShiId()==null?false:true;
        int p=service.addShift(shift);
        ElMessage elm=new ElMessage();
        if(p==1){
            elm.setType("success");
            if(is){
                elm.setMessage("班次修改成功！");
            }else{
                elm.setMessage("班次新增成功！");
            }
        }
        return elm;
    }

    /**
     * 国际时间转换北京时间
     * @param UTCStr
     * @param format
     * @return
     * @throws ParseException
     */
    public Date UTCToCST(String UTCStr, String format) throws ParseException {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        date = sdf.parse(UTCStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
        //calendar.getTime() 返回的是Date类型，也可以使用calendar.getTimeInMillis()获取时间戳
        return calendar.getTime();
    }
}
