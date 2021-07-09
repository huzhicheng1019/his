package cn.gson.his.controller.wjc;

import cn.gson.his.model.pojos.wjc.CardrecordEntity;
import cn.gson.his.model.service.wjc.CardRecordService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController

public class CardRecordController {

    @Autowired
    private CardRecordService crs;


    @RequestMapping("allCardrecord")
    public List<CardrecordEntity>allCardrecord(String record){
        CardrecordEntity cardrecordEntity = JSONObject.parseObject(record, CardrecordEntity.class);
        return  crs.allCardRecord(cardrecordEntity);

    }
}
