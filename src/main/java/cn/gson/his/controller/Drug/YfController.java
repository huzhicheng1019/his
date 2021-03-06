package cn.gson.his.controller.Drug;

import cn.gson.his.model.pojos.Drug.*;
import cn.gson.his.model.service.Drug.YfService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class YfController {
    @Autowired
    YfService yfService;

    @RequestMapping("yfgl")
    public Map<String,Object> getyf(Integer pageNo, Integer size, String nr, String qssj, String jssj){
        System.out.println("nr:"+nr);
        System.out.println("开始时间："+qssj);
        System.out.println("结束时间："+jssj);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date qsj=null;
        Date jsj=null;
        try {
            if(qssj!=null && qssj!="" && jssj!=null && jssj!="") {
                qsj = sdf.parse(qssj);
                jsj = sdf.parse(jssj);

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String, Object> stringObjectMap = yfService.yfselect(pageNo,size,nr,qsj,jsj);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("yfxq")
    public Map<String,Object> getyfxq(String id,String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = yfService.yfxqselect(id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("yfck")
    public Map<String,Object> getck(){
        Map<String, Object> stringObjectMap = yfService.yfckselect();
        return stringObjectMap;
    }

    @RequestMapping("yfcfxq")
    public Map<String,Object> getcfxq(Integer id,String fl){
        Map<String, Object> stringObjectMap = yfService.cfxq(id,fl);
        return stringObjectMap;
    }

    @RequestMapping("yfcfkc")
    public Map<String,Object> getyfcf(Integer id,Integer pid,String fl){
        System.out.println(id);
        System.out.println(pid);
        System.out.println(fl);
        Map<String, Object> stringObjectMap = yfService.yfcfxq(id, pid, fl);
        return stringObjectMap;
    }

    @RequestMapping("add-fy")
    public String fyxz(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(1);
        System.out.println(map.get("pills"));
        System.out.println(map.get("xqsj"));
        PillsEntity pills = mapper.convertValue(map.get("pills"), PillsEntity.class);
        System.out.println(2);
        List<Pillsxq> xqsj=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("xqsj");
        for (Object i : list) {
            System.out.println(i);
            Pillsxq pillsxq = mapper.convertValue(i, Pillsxq.class);
            xqsj.add(pillsxq);
        }
        try {
            yfService.xzfy(pills,xqsj);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("add-bjq")
    public String ypxz(@RequestBody PillsEntity form){
        try {
            yfService.bj(form);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("yfcxid")
    public Map<String,Object> getyfid(String nr){
        System.out.println("nr:"+nr);
        Map<String, Object> stringObjectMap = yfService.yfidselect(nr);
        return stringObjectMap;
    }

    @RequestMapping("yfxqidcx")
    public Map<String,Object> getyfxqid(String id){
        System.out.println(id);
        Map<String, Object> stringObjectMap = yfService.yfxqidcx(id,"");
        return stringObjectMap;
    }

    @RequestMapping("lsyzcx")
    public Map<String,Object> getlsyz(Integer id,String fl){
        System.out.println("nr:"+id);
        Map<String, Object> stringObjectMap = yfService.lsyzselect(id,fl);
        return stringObjectMap;
    }

    @RequestMapping("kscx")
    public Map<String,Object> getkscx(){
        Map<String, Object> stringObjectMap = yfService.kscx();
        return stringObjectMap;
    }

    @RequestMapping("yzcx")
    public Map<String,Object> getyz(Integer id,String fl){
        System.out.println("nr:"+id);
        Map<String, Object> stringObjectMap = yfService.yzcx(id,fl);
        return stringObjectMap;
    }

    @RequestMapping("zyyfgl")
    public Map<String,Object> getztyf(Integer pageNo, Integer size,Integer fl, String nr, String qssj, String jssj){
        System.out.println("nr:"+nr);
        System.out.println("开始时间："+qssj);
        System.out.println("结束时间："+jssj);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date qsj=null;
        Date jsj=null;
        try {
            if(qssj!=null && qssj!="" && jssj!=null && jssj!="") {
                qsj = sdf.parse(qssj);
                jsj = sdf.parse(jssj);

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String, Object> stringObjectMap = yfService.yflyselect(pageNo,size, fl, nr, qsj, jsj);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }
}
