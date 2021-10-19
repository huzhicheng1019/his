package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.Checkout.TestsEntity;
import cn.gson.his.model.service.Outpatient.TextsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wjc")
public class TextsController {

    @Autowired TextsService textsService;
    //查询所有检查检验
    @RequestMapping("txets")
    public List<TestsEntity> selectTest(String typeName,String jycx){
        return textsService.selectTest(typeName,jycx);
    }
}
