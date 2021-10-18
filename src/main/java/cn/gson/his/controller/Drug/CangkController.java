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

    //仓库查询
    @RequestMapping("ckgl")
    public Map<String,Object> getck(Integer pageNo, Integer size,String nr){
        return cangkService.ckselect(pageNo,size,nr);
    }

    //仓库详情查询 pageNo起始页，size页大小，id为仓库编号，nr为模糊查询条件（药品名称或耗材名称）
    @RequestMapping("ckxq")
    public Map<String,Object> getckxq(Integer pageNo, Integer size,Integer id,String nr){
        return cangkService.ckxqselect(pageNo,size,id,nr);
    }

    //仓库信息查询，用于仓库信息修改界面
    @RequestMapping("ckxx")
    public Map<String,Object> getckxx(Integer id, String nr){
        return cangkService.ckxxselect(id,nr);
    }

    //药品查询
    @RequestMapping("ypcx")
    public Map<String,Object> getYp(String nr1){
        //药品实体类，从前台接收模糊查询条件赋值到drugName（药品名称）
        DrugEntity drugEntity= new DrugEntity();
        drugEntity.setDrugName(nr1);
        //查询药品表
        return cangkService.ypselect(drugEntity);
    }

    //耗材查询
    @RequestMapping("concx")
    public Map<String,Object> getcon(String nr2){
        //耗材实体类，从前台接收模糊查询条件赋值到conName（耗材名称）
        ConEntity conEntity = new ConEntity();
        conEntity.setConName(nr2);
        //查询耗材表
        return cangkService.conselect(conEntity);
    }
    // 删除判断(详情记录的删除)
    @RequestMapping("del-pd")
    public String delyp(@RequestBody String libraryxq){
        try {
            //将字符串转为实体类，判断是否有入库与出库记录
            LibraryxqEntity libraryxqEntity = JSONObject.parseObject(libraryxq, LibraryxqEntity.class);
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

    //新增或修改仓库
    @RequestMapping("add-ck")
    public String ckxz(@RequestBody Map<String,Object> map){
        ObjectMapper mapper = new ObjectMapper();
        LibraryInfoEntity library = mapper.convertValue(map.get("library"), LibraryInfoEntity.class);
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

    //仓库删除
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
