package cn.gson.his.controller.Power;

import cn.gson.his.model.pojos.Power.vo.echarts;
import cn.gson.his.model.service.Power.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/lxj")
@RestController
public class HomeworkController {

    @Autowired
    HomeworkService service;

    @RequestMapping("/allHospital")
    public List<echarts> allHospital(){
        return service.allHospital();
    }
}
