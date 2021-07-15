package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.Outpatient.CardEntity;
import cn.gson.his.model.pojos.Outpatient.CardrecordEntity;
import cn.gson.his.model.service.Outpatient.CardRecordService;
import cn.gson.his.model.service.Outpatient.CardService;
import cn.gson.his.model.service.Outpatient.PatientService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
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
    //就诊卡充值记录的
    private CardRecordService srs;

    @RequestMapping("AllCard")
    public List<CardEntity> allCard(String card){
//        try {
            //JSONObject转换为就诊卡实体类对象
            CardEntity cardEntity = JSONObject.parseObject(card, CardEntity.class);
             return cs.AllCard(cardEntity);
//        }catch (Exception e){
//            System.out.println(e.fillInStackTrace());
//
//        }
    }
    //修改本身的金额， 加一条就诊卡充值记录
    @RequestMapping("upCard")
    public String upCard(String card,String name){
        try {
            System.out.println(card+"----"+name);
            //充值卡
            CardEntity cardEntity = JSONObject.parseObject(card, CardEntity.class);
            //充值记录表
            CardrecordEntity cardrecord = new CardrecordEntity();
            //充值的人
            cardrecord.setRecordName(name);
            //充值金额
            cardrecord.setRecordPrice(cardEntity.getCardPrice().intValue());
            //充值时间
            Timestamp time2= new Timestamp(new Date().getTime());
            cardrecord.setRecordDate(time2);
            //充值还是缴费
            cardrecord.setRecordWay("充值");
            //操作的人
            cardrecord.setCollectPrice(1);
            //调用修改方法
            System.out.println("-------------------------"+cardrecord.getCollectPrice());
            cs.UpCard(cardEntity,cardrecord);
            return "OK";
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
            return "NO";
        }
    }

}
