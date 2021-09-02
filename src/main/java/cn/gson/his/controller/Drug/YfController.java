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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class YfController {
    @Autowired
    YfService yfService;

    @RequestMapping("yfgl")
    public Map<String,Object> getyf(Integer pageNo, Integer size, String nr){
        System.out.println("nr:"+nr);
        Map<String, Object> stringObjectMap = yfService.yfselect(pageNo,size,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("yfxq")
    public Map<String,Object> getyfxq(Integer pageNo, Integer size,String id,String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = yfService.yfxqselect(pageNo,size,id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("yfck")
    public Map<String,Object> getck(){
        Map<String, Object> stringObjectMap = yfService.yfckselect();
        return stringObjectMap;
    }

    @RequestMapping("yfcfxq")
    public Map<String,Object> getcfxq(Integer id){
        Map<String, Object> stringObjectMap = yfService.cfxq(id);
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
}
