package cn.gson.his.controller.Drug;

import cn.gson.his.model.pojos.Drug.Allot;
import cn.gson.his.model.pojos.Drug.Allotxq;
import cn.gson.his.model.pojos.Drug.OrdersEntity;
import cn.gson.his.model.pojos.Drug.OrderxqEntity;
import cn.gson.his.model.pojos.Power.Employee;
import cn.gson.his.model.service.Drug.DbsqService;
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
public class DbsqController {
    @Autowired
    DbsqService dbsqService;

    @RequestMapping("dbgl")
    public Map<String,Object> getck(Integer pageNo, Integer size, String nr){
        System.out.println("nr:"+nr);
        Map<String, Object> stringObjectMap = dbsqService.dbselect(pageNo,size,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("dbxq")
    public Map<String,Object> getckxq(Integer pageNo, Integer size,Integer id,String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = dbsqService.dbxqselect(pageNo,size,id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("dbckxq")
    public Map<String,Object> getdbckxq(Integer id,String nr,Integer ckid){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = dbsqService.dbckxqcx(id,nr,ckid);
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
    public Map<String,Object> getcgxx(Integer id){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = dbsqService.dbcxid(id);
        return stringObjectMap;
    }

    @RequestMapping("delxg-dbpd")
    public String delxgcgpd(Integer allotId){
        System.out.println(allotId);
        try {
            return dbsqService.scxgpd(allotId);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("del-db")
    public String delcg(Integer allotId){
        System.out.println(allotId);
        try {
            return dbsqService.dbdel(allotId);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("dbckxqid")
    public Map<String,Object> getdbckxqid(Integer id){
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
        System.out.println(2);
        List<Allotxq> xqsj=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("xqsj");
        for (Object i : list) {
            System.out.println(i);
            Allotxq allotxq = mapper.convertValue(i, Allotxq.class);
            xqsj.add(allotxq);
        }
        try {
            dbsqService.xzdbrck(allot,spr,xqsj);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("dbbh")
    public void dbbh(@RequestBody Allot allot){
        System.out.println("开始：");
        System.out.println(allot);
        dbsqService.bh(allot);
    }
}
