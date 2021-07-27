package cn.gson.his.controller.Drug;

import cn.gson.his.model.pojos.Drug.OrdersEntity;
import cn.gson.his.model.pojos.Drug.OrderxqEntity;
import cn.gson.his.model.pojos.Drug.PlanInfoEntity;
import cn.gson.his.model.pojos.Drug.ProductEntity;
import cn.gson.his.model.service.Drug.CangkService;
import cn.gson.his.model.service.Drug.CgService;
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
public class CgController {
    @Autowired
    CgService cgService;

    @RequestMapping("cggl")
    public Map<String,Object> getcg(Integer pageNo, Integer size, String nr){
        System.out.println("nr:"+nr);
        Map<String, Object> stringObjectMap = cgService.cgcx(pageNo,size,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("cgxq")
    public Map<String,Object> getcgxq(Integer pageNo, Integer size,String id,String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = cgService.cgxqselect(pageNo,size,id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("cgxx")
    public Map<String,Object> getcgxx(String id,String nr){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = cgService.xzcgxx(id, nr);
        return stringObjectMap;
    }

    @RequestMapping("cgemp")
    public Map<String,Object> getemp(){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = cgService.empcx();
        return stringObjectMap;
    }

    @RequestMapping("add-cg")
    public String cgjhxz(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(1);
        System.out.println(map.get("orders"));
        System.out.println(map.get("xqsj"));
        OrdersEntity orders = mapper.convertValue(map.get("orders"), OrdersEntity.class);
        System.out.println(2);
        List<OrderxqEntity> xqsj=new ArrayList<>();
        List<OrderxqEntity> delxq=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("xqsj");
        List<Object> list1 = (List<Object>)map.get("delxq");
        for (Object i : list) {
            System.out.println(i);
            OrderxqEntity orderxqEntity = mapper.convertValue(i, OrderxqEntity.class);
            xqsj.add(orderxqEntity);
        }
        for (Object i : list1){
            OrderxqEntity orderxqEntity = mapper.convertValue(i, OrderxqEntity.class);
            delxq.add(orderxqEntity);
        }
        try {
            cgService.xzxgcg(orders,xqsj,delxq);
//            cangkService.xzgxck(library, xqsj, delxq);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("delxg-cgpd")
    public String delxgcgpd(String orderId){
        System.out.println(orderId);
        try {
            return cgService.scxgpd(orderId);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("del-cg")
    public String delcg(String orderId){
        System.out.println(orderId);
        try {
            return cgService.cgdel(orderId);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
