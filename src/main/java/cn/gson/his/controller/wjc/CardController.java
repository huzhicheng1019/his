package cn.gson.his.controller.wjc;

import cn.gson.his.model.pojos.wjc.CardEntity;
import cn.gson.his.model.pojos.wjc.PatientdataEntity;
import cn.gson.his.model.service.wjc.CardService;
import cn.gson.his.model.service.wjc.PatientService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CardController {

    @Autowired
    //就诊卡的service
    private CardService cs;
    @Autowired
    //患者资料的service
    private PatientService ps;


    @RequestMapping("AllCard")
    public List<CardEntity> allCard(String card){
//        try {
            //JSONObject转换为就诊卡实体类对象

            CardEntity cardEntity = JSONObject.parseObject(card, CardEntity.class);
            List<CardEntity> cardEntities = cs.AllCard(cardEntity);
            System.out.println(cardEntities.get(0).getPati().toString());
             return cs.AllCard(cardEntity);
//        }catch (Exception e){
//            System.out.println(e.fillInStackTrace());
//
//        }
    }

}
