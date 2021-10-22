package cn.gson.his.controller.Drug;

import cn.gson.his.model.mappers.Drug.CgjhMapper;
import cn.gson.his.model.pojos.Drug.*;
import cn.gson.his.model.service.Drug.CgjhService;
import com.alibaba.fastjson.JSONObject;
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
public class CgjhController {
    @Autowired
    CgjhService cgjhService;

//    查询采购计划
    @RequestMapping("cgjh")
    public Map<String,Object> getcgjh(Integer pageNo, Integer size,String nr, String qssj, String jssj,String cgqssj, String cgjssj){
        System.out.println("开始时间："+qssj);
        System.out.println("结束时间："+jssj);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date qsj=null;
        Date jsj=null;
        Date cgqsj=null;
        Date cgjsj=null;
        try {
            if(qssj!=null && qssj!="" && jssj!=null && jssj!=""){
                qsj = sdf.parse(qssj);
                jsj = sdf.parse(jssj);

            }
            if(cgqssj!=null && cgqssj!="" && cgjssj!=null && cgjssj!=""){
                cgqsj = sdf.parse(cgqssj);
                cgjsj = sdf.parse(cgjssj);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String, Object> stringObjectMap = cgjhService.cgjhcx(pageNo,size,nr,qsj,jsj,cgqsj,cgjsj);
        return stringObjectMap;
    }

//    查询采购计划详情
    @RequestMapping("cgjhxq")
    public Map<String,Object> getcgjhxq(String id,String nr){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = cgjhService.cgjhxqcx(id,nr);
        return stringObjectMap;
    }

//    查询采购计划信息
    @RequestMapping("cgjhxx")
    public Map<String,Object> getcgjhxx(String id,String nr){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = cgjhService.xzcgjhxx(id, nr);
        return stringObjectMap;
    }

//    新增修改采购计划
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

//    删除修改采购计划判断
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

//    删除采购计划
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

//    采购计划审核（新增审核记录，修改采购计划审核状态）
    @RequestMapping("cgjh-sh")
    public String cgjhsh(@RequestBody Map<String,Object> map){
        ObjectMapper mapper = new ObjectMapper();
        PlanInfoEntity plan = mapper.convertValue(map.get("plan"), PlanInfoEntity.class);
        System.out.println(map.get("auditInfo"));
        AuditInfo auditInfo=mapper.convertValue(map.get("auditInfo"),AuditInfo.class);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        auditInfo.setApprovalDate(d);
        try {
            cgjhService.sh(plan,auditInfo);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

//    提交审核
    @RequestMapping("cgjh-tjsh")
    public String cgjhtjsh(@RequestBody PlanInfoEntity plan){
        System.out.println(plan.getPlanId());
        try {
            cgjhService.tjsh(plan);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

//    采购订单查询采购计划
    @RequestMapping("cgjhdd")
    public Map<String,Object> getcgjhdd(String nr){
        Map<String, Object> stringObjectMap = cgjhService.cgjhdd(nr);
        return stringObjectMap;
    }

//    采购订单查询计划详情
    @RequestMapping("cgjhddxq")
    public Map<String,Object> getcgjhdd(String id,Integer gid){
        Map<String, Object> stringObjectMap = cgjhService.cgjhddxq(id, gid);
        return stringObjectMap;
    }
}
