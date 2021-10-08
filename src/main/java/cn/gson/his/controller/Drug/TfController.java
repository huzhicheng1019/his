package cn.gson.his.controller.Drug;

import cn.gson.his.model.pojos.Drug.Premium;
import cn.gson.his.model.pojos.Drug.Premiums;
import cn.gson.his.model.pojos.Drug.RefundEntity;
import cn.gson.his.model.pojos.Drug.Refundxq;
import cn.gson.his.model.service.Drug.TfService;
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
public class TfController {
    @Autowired
    TfService tfService;

    @RequestMapping("add-tf")
    public String fyxz(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(1);
        System.out.println(map.get("premium"));
        System.out.println(map.get("tf"));
        Premium premium = mapper.convertValue(map.get("premium"), Premium.class);
        System.out.println(2);
        List<Premiums> xqsj=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("tf");
        for (Object i : list) {
            System.out.println(i);
            Premiums premiums = mapper.convertValue(i, Premiums.class);
            xqsj.add(premiums);
        }
        try {
            tfService.xztf(premium,xqsj);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("tfsqgl")
    public Map<String,Object> gettfsq(Integer pageNo, Integer size, String nr){
        System.out.println("nr:"+nr);
        Map<String, Object> stringObjectMap = tfService.tfsqselect(pageNo,size,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("tfsqxq")
    public Map<String,Object> gettfsqxq(Integer pageNo, Integer size,String id,String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> stringObjectMap = tfService.tfsqxqselect(pageNo,size,id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }
}
