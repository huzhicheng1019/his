package cn.gson.his.controller.Drug;

import cn.gson.his.model.pojos.Drug.*;
import cn.gson.his.model.service.Drug.CangkService;
import cn.gson.his.model.service.Drug.ConService;
import cn.gson.his.model.service.Drug.YpService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class CangkController {
    @Autowired
    CangkService cangkService;

    @RequestMapping("ckgl")
    public Map<String,Object> getck(Integer pageNo, Integer size,String nr){
        System.out.println("nr:"+nr);
        Map<String, Object> stringObjectMap = cangkService.ckselect(pageNo,size,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("ckxq")
    public Map<String,Object> getckxq(Integer pageNo, Integer size,Integer id,String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = cangkService.ckxqselect(pageNo,size,id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("ckxx")
    public Map<String,Object> getckxx(Integer id, String nr){
        Map<String, Object> stringObjectMap = cangkService.ckxxselect(id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("ypcx")
    public Map<String,Object> getYp(String nr1){
        System.out.println(nr1);
        DrugEntity drugEntity= new DrugEntity();
        drugEntity.setDrugName(nr1);
        Map<String, Object> stringObjectMap = cangkService.ypselect(drugEntity);
        return stringObjectMap;
    }

    @RequestMapping("concx")
    public Map<String,Object> getcon(String nr2){
        System.out.println(nr2);
        ConEntity conEntity = new ConEntity();
        conEntity.setConName(nr2);
        Map<String, Object> stringObjectMap = cangkService.conselect(conEntity);
        return stringObjectMap;
    }

    @RequestMapping("del-pd")
    public String delyp(@RequestBody String libraryxq){
        System.out.println(libraryxq);
        LibraryxqEntity libraryxqEntity = JSONObject.parseObject(libraryxq, LibraryxqEntity.class);
        System.out.println(libraryxqEntity.getProductId());
        try {
            int stosize = cangkService.stojlcx(libraryxqEntity);
            int chusize = cangkService.chujlcx(libraryxqEntity);
            if(stosize>0 || chusize>0){
                return "该记录不可删除";
            }else {
                return "ok";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("add-ck")
    public String ckxz(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(1);
        LibraryInfoEntity library = mapper.convertValue(map.get("library"), LibraryInfoEntity.class);
        System.out.println(2);
        List<LibraryxqEntity> xqsj=new ArrayList<>();
        List<LibraryxqEntity> delxq=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("xqsj");
        List<Object> list1 = (List<Object>)map.get("delxq");
        for (Object i : list) {
            System.out.println(i);
            LibraryxqEntity libraryxqEntity = mapper.convertValue(i, LibraryxqEntity.class);
            xqsj.add(libraryxqEntity);
            System.out.println(libraryxqEntity.getScdate());

        }
        for (Object i : list1){
            LibraryxqEntity libraryxqEntity = mapper.convertValue(i, LibraryxqEntity.class);
            delxq.add(libraryxqEntity);
        }
        try {
            cangkService.xzgxck(library,xqsj,delxq);
//            cangkService.xzgxck(library, xqsj, delxq);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("del-ck")
    public String delck(Integer id){
        System.out.println(id);
        try {
            return cangkService.delck(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
