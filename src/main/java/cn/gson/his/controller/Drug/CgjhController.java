package cn.gson.his.controller.Drug;

import cn.gson.his.model.mappers.Drug.CgjhMapper;
import cn.gson.his.model.pojos.Drug.LibraryInfoEntity;
import cn.gson.his.model.pojos.Drug.LibraryxqEntity;
import cn.gson.his.model.pojos.Drug.PlanInfoEntity;
import cn.gson.his.model.pojos.Drug.ProductEntity;
import cn.gson.his.model.service.Drug.CgjhService;
import com.alibaba.fastjson.JSONObject;
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
public class CgjhController {
    @Autowired
    CgjhService cgjhService;

    @RequestMapping("cgjh")
    public Map<String,Object> getcgjh(String nr){
        Map<String, Object> stringObjectMap = cgjhService.cgjhcx(nr);
        return stringObjectMap;
    }

    @RequestMapping("cgjhxq")
    public Map<String,Object> getcgjhxq(String id,String nr){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = cgjhService.cgjhxqcx(id,nr);
        return stringObjectMap;
    }

    @RequestMapping("cgjhxx")
    public Map<String,Object> getcgjhxx(String id,String nr){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = cgjhService.xzcgjhxx(id, nr);
        return stringObjectMap;
    }

    @RequestMapping("add-cgjh")
    public String cgjhxz(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(1);
        System.out.println(map.get("plan"));
        System.out.println(map.get("xqsj"));
        PlanInfoEntity plan = mapper.convertValue(map.get("plan"), PlanInfoEntity.class);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        plan.setPlanDate(d);
        System.out.println(2);
        List<ProductEntity> xqsj=new ArrayList<>();
        List<ProductEntity> delxq=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("xqsj");
        List<Object> list1 = (List<Object>)map.get("delxq");
        for (Object i : list) {
            System.out.println(i);
            ProductEntity productEntity = mapper.convertValue(i, ProductEntity.class);
            xqsj.add(productEntity);
        }
        for (Object i : list1){
            ProductEntity productEntity = mapper.convertValue(i, ProductEntity.class);
            delxq.add(productEntity);
        }
        try {
            cgjhService.xzxgcgjh(plan,xqsj,delxq);
//            cangkService.xzgxck(library, xqsj, delxq);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("delxg-pd")
    public String delxgpd(String planId){
        System.out.println(planId);
        try {
            return cgjhService.scxgpd(planId);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("del-cgjh")
    public String delcgjh(String planId){
        System.out.println(planId);
        try {
            return cgjhService.cgjhdel(planId);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("cgjh-sh")
    public String cgjhsh(@RequestBody PlanInfoEntity plan){
        System.out.println(plan.getPlanId());
        try {
            cgjhService.sh(plan);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("cgjhdd")
    public Map<String,Object> getcgjhdd(String nr){
        Map<String, Object> stringObjectMap = cgjhService.cgjhdd(nr);
        return stringObjectMap;
    }

    @RequestMapping("cgjhddxq")
    public Map<String,Object> getcgjhdd(String id,Integer gid){
        Map<String, Object> stringObjectMap = cgjhService.cgjhddxq(id, gid);
        return stringObjectMap;
    }
}
