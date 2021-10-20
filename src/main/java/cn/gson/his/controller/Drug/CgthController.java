package cn.gson.his.controller.Drug;

import cn.gson.his.model.pojos.Drug.OrdersEntity;
import cn.gson.his.model.pojos.Drug.OrderthEntity;
import cn.gson.his.model.pojos.Drug.OrderthxqEntity;
import cn.gson.his.model.pojos.Drug.OrderxqEntity;
import cn.gson.his.model.service.Drug.CgthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class CgthController {
    @Autowired
    CgthService cgthService;

    @RequestMapping("cgthgl")
    public Map<String,Object> getcg(Integer pageNo, Integer size, String nr, String qssj, String jssj){
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
        Map<String, Object> stringObjectMap = cgthService.cgthcx(pageNo,size,nr,qsj,jsj);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("cgthxq")
    public Map<String,Object> getcgxq(Integer pageNo, Integer size,String id,String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = cgthService.cgthxqselect(pageNo,size,id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("cgrkxq")
    public Map<String,Object> getcgrkxq(String id){
        System.out.println(id);
        Map<String, Object> stringObjectMap = cgthService.cgrkxqcx(id);
        return stringObjectMap;
    }

    @RequestMapping("cgthxx")
    public Map<String,Object> getcgthxx(String id,String nr){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = cgthService.cgthxx(id, nr);
        return stringObjectMap;
    }

    @RequestMapping("add-cgth")
    public String cgthxz(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(1);
        System.out.println(map.get("orderth"));
        System.out.println(map.get("xqsj"));
        OrderthEntity orderth = mapper.convertValue(map.get("orderth"), OrderthEntity.class);
        System.out.println(2);
        List<OrderthxqEntity> xqsj=new ArrayList<>();
        List<OrderthxqEntity> delxq=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("xqsj");
        List<Object> list1 = (List<Object>)map.get("delxq");
        for (Object i : list) {
            System.out.println(i);
            OrderthxqEntity orderthxqEntity = mapper.convertValue(i, OrderthxqEntity.class);
            xqsj.add(orderthxqEntity);
        }
        for (Object i : list1){
            OrderthxqEntity orderthxqEntity = mapper.convertValue(i, OrderthxqEntity.class);
            delxq.add(orderthxqEntity);
        }
        try {
            cgthService.xzxgcgth(orderth,xqsj,delxq);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("delxg-cgthpd")
    public String delxgcgthpd(String orderthId){
        System.out.println(orderthId);
        try {
            return cgthService.scxgpd(orderthId);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("del-cgth")
    public String delcgth(String orderthId){
        System.out.println(orderthId);
        try {
            return cgthService.cgdel(orderthId);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


}
