package cn.gson.his.controller.Drug;

import cn.gson.his.model.service.Drug.SpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class SpController {
    @Autowired
    SpService spService;

    @RequestMapping("spgl")
    public Map<String,Object> getcg(Integer pageNo, Integer size, String why, String nr, String qssj, String jssj){
        System.out.println("why:"+why);
        System.out.println("开始时间："+qssj);
        System.out.println("结束时间："+jssj);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date qsj=null;
        Date jsj=null;
        try {
            if(qssj!=null && qssj!="" && jssj!=null && jssj!=""){
                qsj = sdf.parse(qssj);
                jsj = sdf.parse(jssj);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String, Object> stringObjectMap = spService.spcx(pageNo,size,why,nr,qsj,jsj);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }
}
