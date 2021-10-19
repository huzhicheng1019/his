package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.TextsMappper;
import cn.gson.his.model.pojos.Checkout.TestsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextsService {

    @Autowired
    TextsMappper textsMappper;

    public List<TestsEntity> selectTest(String typeName,String jycx){
        return textsMappper.selectTest(typeName,jycx);
    }
}
