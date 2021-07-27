package cn.gson.his.controller.InHospital;


import cn.gson.his.model.pojos.Drug.ConEntity;
import cn.gson.his.model.service.InHospital.ConsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class ConsController {
    @Autowired
    ConsService consService;

    //查询所有药品
    @RequestMapping("/selCon")
    public List<ConEntity> selCon(String conText){
        System.out.println(conText);
        return consService.selCon(conText);
    };
}
