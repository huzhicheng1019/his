package cn.gson.his.controller.InHospital;

import cn.gson.his.model.pojos.Drug.DrugEntity;
import cn.gson.his.model.pojos.Drug.LbEntity;
import cn.gson.his.model.service.InHospital.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class DrugController {
    @Autowired
    DrugService drugService;


    //查询所有药品
    @RequestMapping("/selDrug")
    public List<DrugEntity> selDrug(String typeId,String drugText){
        return drugService.selDrug(typeId,drugText);
    };


    //查询所有分类
    @RequestMapping("/selLb")
    public List<LbEntity> selLb(String lbFl){
        return drugService.selLb(lbFl);
    };

}
