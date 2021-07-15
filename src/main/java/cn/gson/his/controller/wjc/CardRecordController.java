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

    //查询就诊卡充值记录
    @RequestMapping("allCardrecord")
    public List<CardrecordEntity>allCardrecord(String record){
        System.out.println(record);
        //转对象
        CardrecordEntity cardrecordEntity = JSONObject.parseObject(record, CardrecordEntity.class);
        //返回出去
        return  crs.allCardRecord(cardrecordEntity);
    }
}
