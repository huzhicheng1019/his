package cn.gson.his.controller.InHospital;

import cn.gson.his.model.pojos.Checkout.OperationItemEntity;
import cn.gson.his.model.pojos.InHospital.DoctorEnjoinEntity;
import cn.gson.his.model.service.InHospital.OperationItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class OperationItemController {
    @Autowired
    OperationItemService itemService;


    //查询所有手术项目
    @RequestMapping("/selItem")
    public List<OperationItemEntity> demo(){
        return itemService.selItem();
    }
}
