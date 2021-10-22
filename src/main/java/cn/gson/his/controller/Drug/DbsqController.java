package cn.gson.his.controller.Drug;

import cn.gson.his.model.pojos.Drug.*;
import cn.gson.his.model.pojos.Power.Employee;
import cn.gson.his.model.service.Drug.DbsqService;
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
public class DbsqController {
    @Autowired
    DbsqService dbsqService;

    @RequestMapping("dbgl")
    public Map<String,Object> getck(Integer pageNo, Integer size, String nr, String qssj, String jssj, String dbqssj, String dbjssj){
        System.out.println("nr:"+nr);
        System.out.println("开始时间："+qssj);
        System.out.println("结束时间："+jssj);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date qsj=null;
        Date jsj=null;
        Date dbqsj=null;
        Date dbjsj=null;
        try {
            if(qssj!=null && qssj!="" && jssj!=null && jssj!="") {
                qsj = sdf.parse(qssj);
                jsj = sdf.parse(jssj);

            }
            if(dbqssj!=null && dbqssj!="" && dbjssj!=null && dbjssj!=""){
                dbqsj = sdf.parse(dbqssj);
                dbjsj = sdf.parse(dbjssj);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String, Object> stringObjectMap = dbsqService.dbselect(pageNo,size,nr,qsj,jsj,dbqsj,dbjsj);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("dbxq")
    public Map<String,Object> getckxq(String id,String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = dbsqService.dbxqselect(id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("dbckxq")
    public Map<String,Object> getdbckxq(Integer id,String nr,Integer ckid,Integer ckdj){
        System.out.println(id);
        System.out.println(nr);
        System.out.println("仓库等级："+ckdj);
        Map<String, Object> stringObjectMap = dbsqService.dbckxqcx(id,nr,ckid,ckdj);
        return stringObjectMap;
    }

    @RequestMapping("add-db")
    public String dbxz(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(1);
        System.out.println(map.get("allot"));
        System.out.println(map.get("xqsj"));
        Allot allot = mapper.convertValue(map.get("allot"), Allot.class);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        allot.setSqdate(d);
        System.out.println(2);
        List<Allotxq> xqsj=new ArrayList<>();
        List<Allotxq> delxq=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("xqsj");
        List<Object> list1 = (List<Object>)map.get("delxq");
        for (Object i : list) {
            System.out.println(i);
            Allotxq allotxq = mapper.convertValue(i, Allotxq.class);
            xqsj.add(allotxq);
        }
        for (Object i : list1){
            Allotxq allotxq = mapper.convertValue(i, Allotxq.class);
            delxq.add(allotxq);
        }
        try {
            dbsqService.xzxgdb(allot,xqsj,delxq);
//            cangkService.xzgxck(library, xqsj, delxq);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("dbxx")
    public Map<String,Object> getcgxx(String id){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = dbsqService.dbcxid(id);
        return stringObjectMap;
    }

    @RequestMapping("delxg-dbpd")
    public String delxgcgpd(String allotId){
        System.out.println(allotId);
        try {
            return dbsqService.scxgpd(allotId);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("del-db")
    public String delcg(String allotId){
        System.out.println(allotId);
        try {
            return dbsqService.dbdel(allotId);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("dbckxqid")
    public Map<String,Object> getdbckxqid(String id){
        Map<String, Object> stringObjectMap = dbsqService.shdb(id);
        return stringObjectMap;
    }

    @RequestMapping("add-dbrck")
    public String dbrckxz(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(1);
        System.out.println(map.get("allot"));
        System.out.println(map.get("xqsj"));
        System.out.println(map.get("spr"));
        Allot allot = mapper.convertValue(map.get("allot"), Allot.class);
        Employee spr = mapper.convertValue(map.get("spr"), Employee.class);
        AuditInfo auditInfo=mapper.convertValue(map.get("auditInfo"),AuditInfo.class);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        auditInfo.setApprovalDate(d);
        System.out.println(2);
        List<Allotxq> xqsj=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("xqsj");
        for (Object i : list) {
            System.out.println(i);
            Allotxq allotxq = mapper.convertValue(i, Allotxq.class);
            xqsj.add(allotxq);
        }
        try {
            dbsqService.xzdbrck(allot,spr,xqsj,auditInfo);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("dbbh")
    public void dbbh(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        Allot allot = mapper.convertValue(map.get("allot"), Allot.class);
        AuditInfo auditInfo=mapper.convertValue(map.get("auditInfo"),AuditInfo.class);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        auditInfo.setApprovalDate(d);
        dbsqService.bh(allot,auditInfo);
    }

    @RequestMapping("dbtjsh")
    public void dbtjsh(@RequestBody Allot allot){
        System.out.println("开始：");
        dbsqService.tjsh(allot);
    }
}
