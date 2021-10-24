package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.TextsMappper;
import cn.gson.his.model.pojos.Checkout.TestDetailsEntity;
import cn.gson.his.model.pojos.Checkout.TestsEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TextsService {

    @Autowired
    TextsMappper textsMappper;

    public List<TestsEntity> selectTest(String typeName,String jycx){
        return textsMappper.selectTest(typeName,jycx);
    }



    //新增检验
    @Transactional
    public int addTest(TestsEntity testsEntity,TestDetailsEntity testDetailsEntity){
        textsMappper.addTest(testsEntity);
        testDetailsEntity.setTestsId((int)testsEntity.getTestId());
        return  textsMappper.insertdetails(testDetailsEntity);
    }
    //修改是否停用
    public int upTestsDetails(int state,int test){
        return textsMappper.upTestsDetails(state,test);
    }
    //修改检验检查
    public int upTest(TestsEntity testsEntity){
        return textsMappper.upTest(testsEntity);
    }
    //修改详情
    public int upDetails(TestDetailsEntity testDetailsEntity){
        return textsMappper.upDetails(testDetailsEntity);
    }

}
