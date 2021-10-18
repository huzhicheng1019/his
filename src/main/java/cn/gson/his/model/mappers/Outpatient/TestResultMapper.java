package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.TestResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface TestResultMapper {
        //新增化验结果
        public int addTestResult(TestResult testResult);

}
