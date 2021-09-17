package cn.gson.his.controller.Drug;

import cn.gson.his.model.pojos.Drug.PillsEntity;
import cn.gson.his.model.pojos.Drug.Pillsxq;
import cn.gson.his.model.pojos.Drug.RefundEntity;
import cn.gson.his.model.pojos.Drug.Refundxq;
import cn.gson.his.model.service.Drug.TyService;
import cn.gson.his.model.service.Drug.YfService;
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
public class TyController {
    @Autowired
    TyService tyService;

    @RequestMapping("tygl")
    public Map<String,Object> getty(Integer pageNo, Integer size, String nr){
        System.out.println("nr:"+nr);
        Map<String, Object> stringObjectMap = tyService.tyselect(pageNo,size,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("tyxq")
    public Map<String,Object> gettyxq(Integer pageNo, Integer size,String id,String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = tyService.tyxqselect(pageNo,size,id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("add-ty")
    public String fyxz(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(1);
        System.out.println(map.get("refund"));
        System.out.println(map.get("xqsj"));
        RefundEntity refund = mapper.convertValue(map.get("refund"), RefundEntity.class);
        System.out.println(2);
        List<Refundxq> xqsj=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("xqsj");
        for (Object i : list) {
            System.out.println(i);
            Refundxq refundxq = mapper.convertValue(i, Refundxq.class);
            xqsj.add(refundxq);
        }
        try {
            tyService.tyxz(refund,xqsj);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
