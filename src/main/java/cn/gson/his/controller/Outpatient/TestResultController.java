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

@RestController
@RequestMapping("wjc")
public class TestResultController {

    @Autowired
    TestResultService testResultService;

    @Autowired ExamineService examineService;

    @Autowired ChangepartService changepart;

    @RequestMapping("addtestResult")
    public int addTestResult(String testResult,String examineNo){
        System.out.println(testResult);
        TestResult testResult1 = JSONObject.parseObject(testResult,TestResult.class);

        examineService.upExamineID("2",Integer.valueOf(examineNo));

        changepart.upChangepartJG(Integer.valueOf(examineNo));
        return testResultService.addTestResult(testResult1);
    }
}
