package cn.gson.his.controller.Drug;

import cn.gson.his.model.pojos.Drug.*;
import cn.gson.his.model.pojos.Power.Employee;
import cn.gson.his.model.service.Drug.XhService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.After;
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
public class XhController {
    @Autowired
    XhService xhService;

    @RequestMapping("xhgl")
    public Map<String,Object> getxh(Integer pageNo, Integer size, String nr){
        System.out.println("nr:"+nr);
        Map<String, Object> stringObjectMap = xhService.xhselect(pageNo,size,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("xhxq")
    public Map<String,Object> getxhxq(Integer pageNo, Integer size,String id,String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = xhService.xhxqselect(pageNo,size,id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("add-xh")
    public String dbxz(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(1);
        System.out.println(map.get("destroy"));
        System.out.println(map.get("xqsj"));
        Destroy destroy = mapper.convertValue(map.get("destroy"), Destroy.class);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        destroy.setSqdate(d);
        System.out.println(2);
        List<Destroyxq> xqsj=new ArrayList<>();
        List<Destroyxq> delxq=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("xqsj");
        List<Object> list1 = (List<Object>)map.get("delxq");
        for (Object i : list) {
            System.out.println(i);
            Destroyxq destroyxq = mapper.convertValue(i, Destroyxq.class);
            xqsj.add(destroyxq);
        }
        for (Object i : list1){
            Destroyxq destroyxq = mapper.convertValue(i, Destroyxq.class);
            delxq.add(destroyxq);
        }
        try {
            xhService.xzxgxh(destroy,xqsj,delxq);
//            cangkService.xzgxck(library, xqsj, delxq);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("xhxx")
    public Map<String,Object> getxhxx(String id){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = xhService.xhcxid(id);
        return stringObjectMap;
    }

    @RequestMapping("del-xh")
    public String delcg(String destroyId){
        System.out.println(destroyId);
        try {
            xhService.xhdel(destroyId);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("xhckxqid")
    public Map<String,Object> getdbckxqid(String id){
        Map<String, Object> stringObjectMap = xhService.shxh(id);
        return stringObjectMap;
    }

    @RequestMapping("xhbh")
    public void xhbh(@RequestBody Map<String,Object> map){
        ObjectMapper mapper = new ObjectMapper();
        Destroy destroy = mapper.convertValue(map.get("destroy"), Destroy.class);
        AuditInfo auditInfo=mapper.convertValue(map.get("auditInfo"),AuditInfo.class);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        auditInfo.setApprovalDate(d);
        System.out.println("开始：");
        System.out.println(destroy);
        xhService.bh(destroy,auditInfo);
    }

    @RequestMapping("add-xhrck")
    public String xhrckxz(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(1);
        System.out.println(map.get("destroy"));
        System.out.println(map.get("xqsj"));
        System.out.println(map.get("spr"));
        Destroy destroy = mapper.convertValue(map.get("destroy"), Destroy.class);
        Employee spr = mapper.convertValue(map.get("spr"), Employee.class);
        AuditInfo auditInfo=mapper.convertValue(map.get("auditInfo"),AuditInfo.class);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        auditInfo.setApprovalDate(d);
        System.out.println(2);
        List<Destroyxq> xqsj=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("xqsj");
        for (Object i : list) {
            System.out.println(i);
            Destroyxq destroyxq = mapper.convertValue(i, Destroyxq.class);
            xqsj.add(destroyxq);
        }
        try {
            xhService.xzxhrck(destroy,spr,xqsj,auditInfo);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("xhtjsh")
    public void xhtjsh(@RequestBody Destroy destroy){
        System.out.println("开始：");
        xhService.xhtjsh(destroy);
    }
}
