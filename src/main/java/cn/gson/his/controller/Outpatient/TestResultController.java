package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.Outpatient.ChangepartEntity;
import cn.gson.his.model.pojos.Outpatient.TestResult;
import cn.gson.his.model.service.Outpatient.ChangepartService;
import cn.gson.his.model.service.Outpatient.ExamineService;
import cn.gson.his.model.service.Outpatient.TestResultService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wjc")
public class TestResultController {

    @Autowired
    TestResultService testResultService;

    @Autowired ExamineService examineService;

    @Autowired ChangepartService changepart;

    //新增住院的结果
    @RequestMapping("addZYtestResult")
    public int addZYtestResult(String testResult,String examineNo,String record_id,int price){
        TestResult testResult1 = JSONObject.parseObject(testResult,TestResult.class);

        examineService.upExamineID("4",Integer.valueOf(examineNo));

        changepart.upChangepartJG(4,Integer.valueOf(examineNo));

       return testResultService.addZYtestResult(testResult1,examineNo,record_id,price);
    }
    @RequestMapping("addtestResult")
    public int addTestResult(String testResult,String examineNo){
        System.out.println(testResult);

        TestResult testResult1 = JSONObject.parseObject(testResult,TestResult.class);
        examineService.upExamineID("5",Integer.valueOf(examineNo));

        changepart.upChangepartJG(5,Integer.valueOf(examineNo));
        return testResultService.addTestResult(testResult1);
    }

    //查询结果
    @RequestMapping("allTestResult")
    public List<TestResult> allTestResult(int pesult){
        return  testResultService.allTestResult(pesult);
    }
}
