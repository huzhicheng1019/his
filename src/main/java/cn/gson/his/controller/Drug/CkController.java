package cn.gson.his.controller.Drug;

import cn.gson.his.model.pojos.Drug.ChuEntity;
import cn.gson.his.model.pojos.Drug.ChujlEntity;
import cn.gson.his.model.pojos.Drug.StoEntity;
import cn.gson.his.model.pojos.Drug.StojlEntity;
import cn.gson.his.model.service.Drug.CkService;
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
public class CkController {
    @Autowired
    CkService ckService;

    @RequestMapping("chukgl")
    public Map<String,Object> getchu(Integer pageNo, Integer size, String why, String nr, String qssj, String jssj){
        System.out.println("nr:"+nr);
        System.out.println("开始时间："+qssj);
        System.out.println("结束时间："+jssj);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date qsj=null;
        Date jsj=null;
        try {
            if(qssj!=null && qssj!="" && jssj!=null && jssj!="") {
                qsj = sdf.parse(qssj);
                jsj = sdf.parse(jssj);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String, Object> stringObjectMap = ckService.chucx(pageNo,size,why,nr,qsj,jsj);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("chukxq")
    public Map<String,Object> getchuxq(Integer id, String nr){
        System.out.println("nr:"+nr);
        Map<String, Object> stringObjectMap = ckService.chuxqcx(id,nr);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("sycgth")
    public Map<String,Object> getsycgth(String nr){
        System.out.println("开始：");
        Map<String, Object> stringObjectMap = ckService.cgthcx(nr);
        return stringObjectMap;
    }

    @RequestMapping("thxqid")
    public Map<String,Object> getcgxq(String id,Integer libraryId){
        System.out.println("退货详情开始：");
        System.out.println(id);
        System.out.println(libraryId);
        Map<String, Object> stringObjectMap = ckService.cgthxqcx(id,libraryId);
        return stringObjectMap;
    }

    @RequestMapping("add-chuk")
    public String chukxz(@RequestBody Map<String,Object> map){
        System.out.println("开始：");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(1);
        System.out.println(map.get("chu"));
        System.out.println(map.get("xqsj"));
        ChuEntity chu = mapper.convertValue(map.get("chu"), ChuEntity.class);
        List<ChujlEntity> xqsj=new ArrayList<>();
        List<Object> list = (List<Object>)map.get("xqsj");
        for (Object i : list) {
            System.out.println(i);
            ChujlEntity chujlEntity = mapper.convertValue(i, ChujlEntity.class);
            xqsj.add(chujlEntity);
        }
        try {
            ckService.xzchu(chu,xqsj);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
