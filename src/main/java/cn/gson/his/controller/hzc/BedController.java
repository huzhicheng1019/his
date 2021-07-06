package cn.gson.his.controller.hzc;


import cn.gson.his.model.service.hzc.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class BedController {
    @Autowired
    BedService bedService;

    //查询所有床位 带分页
    @RequestMapping("/selBed")
    public Map<String,Object> demo(Integer pageNo, Integer pageSize){
        return bedService.selectBed(pageNo,pageSize);
    }
}
