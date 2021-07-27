package cn.gson.his.controller.Power;

import cn.gson.his.model.pojos.Power.ShiftType;
import cn.gson.his.model.service.Power.ShiftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lxj")
public class ShiftTypeController {

    @Autowired
    ShiftTypeService service;

    @RequestMapping("/allType")
    public List<ShiftType> allType(){
        return service.allType();
    }
}
