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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class CgController {
    @Autowired
    CgService cgService;

    //采购订单查询（采购订单界面）
    @RequestMapping("cggl")
    public Map<String,Object> getcg(Integer pageNo, Integer size, String nr,String cgqssj, String cgjssj){
        System.out.println("nr:"+nr);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date cgqsj=null;
        Date cgjsj=null;
        try {
            if(cgqssj!=null && cgqssj!="" && cgjssj!=null && cgjssj!=""){
                cgqsj = sdf.parse(cgqssj);
                cgjsj = sdf.parse(cgjssj);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String, Object> stringObjectMap = cgService.cgcx(pageNo,size,nr,cgqsj,cgjsj);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

//    采购订单详情查询（采购订单详情界面）
    @RequestMapping("cgxq")
    public Map<String,Object> getcgxq(String id,String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = cgService.cgxqselect(id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    // 采购信息查询（修改界面）
    @RequestMapping("cgxx")
    public Map<String,Object> getcgxx(String id,String nr){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = cgService.xzcgxx(id, nr);
        return stringObjectMap;
    }

//    员工查询
    @RequestMapping("cgemp")
    public Map<String,Object> getemp(Integer id){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = cgService.empcx(id);
        return stringObjectMap;
    }

//    新增修改采购订单
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

//    删除修改采购订单判断
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

//    删除采购订单
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

//    供应商显示
    @RequestMapping("gysxs")
    public Map<String,Object> getgysxs(){
        Map<String, Object> stringObjectMap = cgService.gyscx();
        return stringObjectMap;
    }
}
