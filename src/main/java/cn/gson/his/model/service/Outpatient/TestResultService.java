package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.TestResultMapper;
import cn.gson.his.model.pojos.Outpatient.TestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestResultService{
    @Autowired
    TestResultMapper resultMapper;
    //新增检查结果
    public int addTestResult(TestResult testResult){
        return resultMapper.addTestResult(testResult);
    }

}
