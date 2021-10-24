package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.Checkout.TestDetailsEntity;
import cn.gson.his.model.pojos.Checkout.TestsEntity;
import cn.gson.his.model.service.Outpatient.TextsService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wjc")
public class TextsController {

    @Autowired TextsService textsService;
    //查询所有检查检验
    @RequestMapping("txets")
    public List<TestsEntity> selectTest(String typeName,String jycx){
        return textsService.selectTest(typeName,jycx);
    }

    //新增检验 和 详情
    @RequestMapping("addTest")
    public int addTest(@RequestBody Map<String,Object> date){
        System.out.println(date.get("testsEntity"));
        System.out.println(date.get("testDetailsEntity"));
        LinkedHashMap prescription = (LinkedHashMap)date.get("testsEntity");
        String testsEntity = JSONObject.toJSONString(prescription);
        TestsEntity testsEntity1 = JSONObject.parseObject(testsEntity,TestsEntity.class);

        String testDetails = JSONObject.toJSONString(date.get("testDetailsEntity"));
        TestDetailsEntity testDetailsEntity = JSONObject.parseObject(testDetails,TestDetailsEntity.class);
        System.out.println(testDetailsEntity.toString());
        return textsService.addTest(testsEntity1,testDetailsEntity);

    }
    //修改是否停用
    @RequestMapping("upTestsDetails")
    public int upTestsDetails(int state,int test){
        return textsService.upTestsDetails(state,test);
    }
    //修改检验检查 修改详情
    @RequestMapping("upTest")
    public int upTest(@RequestBody Map<String,Object> date){
        LinkedHashMap prescription = (LinkedHashMap)date.get("testsEntity");
        String testsEntity = JSONObject.toJSONString(prescription);
        TestsEntity testsEntity1 = JSONObject.parseObject(testsEntity,TestsEntity.class);

        String testDetails = JSONObject.toJSONString(date.get("testDetailsEntity"));
        TestDetailsEntity testDetailsEntity = JSONObject.parseObject(testDetails,TestDetailsEntity.class);
        textsService.upDetails(testDetailsEntity);
        return textsService.upTest(testsEntity1);
    }
}
