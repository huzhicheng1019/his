package cn.gson.his.controller.Drug;

import cn.gson.his.model.pojos.Drug.OrdersEntity;
import cn.gson.his.model.pojos.Drug.OrderxqEntity;
import cn.gson.his.model.pojos.Drug.StoEntity;
import cn.gson.his.model.pojos.Drug.StojlEntity;
import cn.gson.his.model.service.Drug.RkService;
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
public class RkController {
    @Autowired
    RkService rkService;

    @RequestMapping("rkgl")
    public Map<String,Object> getck(Integer pageNo, Integer size,String why, String nr){
        System.out.println("nr:"+nr);
        Map<String, Object> stringObjectMap = rkService.rkcx(pageNo,size,why,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("rkxq")
    public Map<String,Object> getrkxq(Integer pageNo, Integer size,Integer id, String nr){
        System.out.println("nr:"+nr);
        Map<String, Object> stringObjectMap = rkService.rkxqcx(pageNo,size,id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }


    @RequestMapping("rkxx")
    public Map<String,Object> getcgxx(Integer id,String nr){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = rkService.xzrkxx(id, nr);
        return stringObjectMap;
    }

    @RequestMapping("syck")
    public Map<String,Object> getck(){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = rkService.ck();
        return stringObjectMap;
    }

    @RequestMapping("sycg")
    public Map<String,Object> getsycg(String nr){
        System.out.println("开始：");
        System.out.println(nr);
        Map<String, Object> stringObjectMap = rkService.cgcx(nr);
        return stringObjectMap;
    }

    @RequestMapping("cgxqid")
    public Map<String,Object> getcgxq(String id,String fl){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = rkService.cgxqcx(id,fl);
        return stringObjectMap;
    }

    @RequestMapping("add-rk")
    public String rkxz(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(1);
        System.out.println(map.get("sto"));
        System.out.println(map.get("xqsj"));
        StoEntity sto = mapper.convertValue(map.get("sto"), StoEntity.class);
        List<StojlEntity> xqsj=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("xqsj");
        for (Object i : list) {
            System.out.println(i);
            StojlEntity stojlEntity = mapper.convertValue(i, StojlEntity.class);
            xqsj.add(stojlEntity);
        }
        try {
            rkService.xzsto(sto,xqsj);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
