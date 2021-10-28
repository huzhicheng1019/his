package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.InHospital.PrepayDetailsMapper;
import cn.gson.his.model.mappers.InHospital.PrepayMapper;
import cn.gson.his.model.mappers.Outpatient.TestResultMapper;
import cn.gson.his.model.pojos.InHospital.PrepayDetailsEntity;
import cn.gson.his.model.pojos.InHospital.PrepayEntity;
import cn.gson.his.model.pojos.Outpatient.PaypartEntity;
import cn.gson.his.model.pojos.Outpatient.TestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestResultService{
    @Autowired
    TestResultMapper resultMapper;
    @Autowired
    PrepayMapper prepayMapper;
    @Autowired
    PrepayDetailsMapper prepayDetailsMapper;
    //新增检查结果
    public int addTestResult(TestResult testResult){
//        String no =  testResult.getChangepartNo().substring(0,2);
//        System.out.println(testResult.getChangepartNo());
//        System.out.println("00000000"+no);
//        if(no.equals("zy")){
//            System.out.println(no.equals("zy"));
//            return 2;
//        }else{
//            return 1;
//        }
        return resultMapper.addTestResult(testResult);
    }
    public int addZYtestResult(TestResult testResult,String examineNo,String record_id,int price){
        //根据住院号查询押金表
        PrepayEntity prepayEntity = prepayMapper.selectPre(record_id);
        prepayEntity.setPreBalance(Double.valueOf(price));
        //修改押金表金额
        prepayMapper.updatePre1(prepayEntity);
        //新增押金详情
        PrepayDetailsEntity prepayDetailsEntity = new PrepayDetailsEntity();
        //金额
        prepayDetailsEntity.setPresPrice(Double.valueOf(price));
        prepayDetailsEntity.setItemId(0);
        prepayDetailsEntity.setPresType(1);
        prepayDetailsEntity.setPreId(prepayEntity.getPreId());
        prepayDetailsEntity.setPreText("检查化验扣费");
        prepayDetailsMapper.insertPreDet(prepayDetailsEntity);
        return resultMapper.addTestResult(testResult);
    };
    //查询结果
    public List<TestResult> allTestResult(int pesult){
        return  resultMapper.allTestResult(pesult);
    }
}
