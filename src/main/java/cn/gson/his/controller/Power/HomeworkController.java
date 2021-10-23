package cn.gson.his.controller.Power;

import cn.gson.his.model.pojos.Power.vo.echarts;
import cn.gson.his.model.service.Power.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/lxj")
@RestController
public class HomeworkController {

    @Autowired
    HomeworkService service;

    @GetMapping("/allHospital")
    public Map<String,List<Integer>> allHospital(String year){
        //String year = map.get("year")+"";
        return service.allHospital(year);
    }
}
