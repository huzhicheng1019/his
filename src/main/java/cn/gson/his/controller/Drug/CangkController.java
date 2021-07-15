package cn.gson.his.controller.llw;

import cn.gson.his.model.pojos.llw.*;
import cn.gson.his.model.service.llw.CangkService;
import cn.gson.his.model.service.llw.ConService;
import cn.gson.his.model.service.llw.YpService;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class CangkController {
    @Autowired
    CangkService cangkService;

    @RequestMapping("ckgl")
    public Map<String,Object> getck(Integer pageNo, Integer size, String nr){
        Map<String, Object> stringObjectMap = cangkService.ckselect(pageNo,size,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("ckxq")
    public Map<String,Object> getckxq(Integer pageNo, Integer size,Integer id, String nr){
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
    public String ckxz(@RequestBody String library,@RequestBody String xqsj,@RequestBody  String delxq){
        System.out.println(library);
//        ObjectMapper mapper=new ObjectMapper();
//        mapper.readValue();
        System.out.println(xqsj);
        System.out.println(delxq);
        try {
//            cangkService.xzgxck(library, xqsj, delxq);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
