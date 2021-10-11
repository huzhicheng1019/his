package cn.gson.his.controller.Drug;

import cn.gson.his.model.pojos.Drug.*;
import cn.gson.his.model.pojos.Power.Employee;
import cn.gson.his.model.service.Drug.PdService;
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
public class PdController {
    @Autowired
    PdService pdService;

    @RequestMapping("ckpdxs")
    public Map<String,Object> getPdckxq(Integer id,Integer lx){
        System.out.println(id);
        System.out.println(lx);
        Map<String, Object> stringObjectMap = pdService.ckpdcx(id,lx);
        return stringObjectMap;
    }

    @RequestMapping("add-pd")
    public String dbxz(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(1);
        System.out.println(map.get("checks"));
        System.out.println(map.get("xqsj"));
        ChecksEntity checks = mapper.convertValue(map.get("checks"), ChecksEntity.class);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        checks.setCheckDate(d);
        System.out.println(2);
        List<Checkxq> xqsj=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("xqsj");
        for (Object i : list) {
            System.out.println(i);
            Checkxq checkxq = mapper.convertValue(i, Checkxq.class);
            xqsj.add(checkxq);
        }
        try {
            pdService.xzPd(checks,xqsj);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("pdgl")
    public Map<String,Object> getpd(Integer pageNo, Integer size, String nr){
        System.out.println("nr:"+nr);
        Map<String, Object> stringObjectMap = pdService.pdselect(pageNo,size,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("pdxq")
    public Map<String,Object> getpdxq(Integer pageNo, Integer size,String id,String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = pdService.pdxqselect(pageNo,size,id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("shpdxq")
    public Map<String,Object> getshpdxq(String id){
        System.out.println(id);
        Map<String, Object> stringObjectMap = pdService.shpdxqcx(id);
        return stringObjectMap;
    }

    @RequestMapping("pdbh")
    public void pdbh(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        ChecksEntity checks = mapper.convertValue(map.get("checks"), ChecksEntity.class);
        AuditInfo auditInfo=mapper.convertValue(map.get("auditInfo"),AuditInfo.class);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        auditInfo.setApprovalDate(d);
        System.out.println(checks);
        pdService.bh(checks,auditInfo);
    }

    @RequestMapping("pdsh")
    public String pdsh(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(1);
        System.out.println(map.get("destroy"));
        System.out.println(map.get("xqsj"));
        System.out.println(map.get("checks"));
        System.out.println(map.get("checkxq"));
        Destroy destroy = mapper.convertValue(map.get("destroy"), Destroy.class);
        ChecksEntity checks = mapper.convertValue(map.get("checks"), ChecksEntity.class);
        System.out.println(2);
        List<Destroyxq> xqsj=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("xqsj");
        List<Checkxq> checkxq=new ArrayList<>();
        List<Object> list1 = (List<Object>)map.get("checkxq");
        for (Object i : list) {
            System.out.println(i);
            Destroyxq destroyxq = mapper.convertValue(i, Destroyxq.class);
            xqsj.add(destroyxq);
        }
        for (Object o : list1) {
            System.out.println(o);
            Checkxq checkxq1 = mapper.convertValue(o, Checkxq.class);
            checkxq.add(checkxq1);
        }
        AuditInfo auditInfo=mapper.convertValue(map.get("auditInfo"),AuditInfo.class);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        auditInfo.setApprovalDate(d);
        try {
            pdService.pdsh(checks,checkxq,destroy,xqsj,auditInfo);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
