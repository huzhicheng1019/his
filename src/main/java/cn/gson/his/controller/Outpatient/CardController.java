package cn.gson.his.controller.Outpatient;


import cn.gson.his.model.pojos.Outpatient.CardEntity;
import cn.gson.his.model.pojos.Outpatient.CardrecordEntity;
import cn.gson.his.model.service.Outpatient.CardRecordService;
import cn.gson.his.model.service.Outpatient.CardService;
import cn.gson.his.model.service.Outpatient.PatientService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
public class CardController<SJSONObject> {

    @Autowired
    //就诊卡的service
    private CardService cs;
    @Autowired
    //患者资料的service
    private PatientService ps;
    //就诊卡充值记录的
    private CardRecordService srs;
    //新增就诊卡
    @ResponseBody
    @RequestMapping("addCard")
    public String addCard(@RequestBody Map<String,Object> datas){
        try {
            //new 一个就诊卡对象 set 赋值
            CardEntity card = new CardEntity();
            //默认密码123456
            card.setCardPswd("123456");
            //根据时间生成就诊卡号
            Date date = new Date();//获取当前的日期
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String str = df.format(date);//获取String类型的时间
            String response = str.replaceAll("[[\\s-:punct:]]","");
            card.setCardNo(response);
            //余额
            card.setCardPrice(0L);
            //预交金额
            card.setCardPrepay(0L);
            //病人姓名
            card.setPatientName((String) datas.get("patientName"));
            //病人的编号
            card.setPatientNo(Integer.valueOf((int)datas.get("patientNo")));
            //就诊卡状态
            card.setCardState(1);
            cs.AddCard(card);
            return response;
        }catch (Exception e){
            return "NO";
        }
    }
    //查询
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
    public String upCard(String card,String name,String EmpName){
//        try {
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
            cardrecord.setRecordWay("0");
            //原因
            cardrecord.setRecordCause("充值");
            //操作的人
            cardrecord.setCollectPrice(EmpName);
            //调用修改方法
            System.out.println("-"+cardrecord.getCollectPrice());
            int s = cs.UpCard(cardEntity, cardrecord);
            if (s == 1){
                return "OK";
            }else {
                return "NO";
            }
//        }catch (Exception e){
//            System.out.println(e.fillInStackTrace());
//            return "NO";
//        }
    }
    //缴费新增就诊卡充值记录
    @RequestMapping("addCardJl")
    public String addCardJl(String cardRecor,String card,String type){

        try {
            //充值记录表
            CardrecordEntity cardrecord = JSONObject.parseObject(cardRecor, CardrecordEntity.class);
            //就诊卡
            CardEntity cardEntity = JSONObject.parseObject(card,CardEntity.class);
            //充值时间
            Timestamp time2= new Timestamp(new Date().getTime());
            cardrecord.setRecordDate(time2);
            //充值还是缴费
            cardrecord.setRecordWay("1");
            cardrecord.setRecordCause(type);
            //调用修改方法
            int s = cs.addCardJl(cardrecord,cardEntity);
            if (s == 1){
                return "OK";
            }else {
                return "NO";
            }
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
            return "NO";
        }
    }
    @RequestMapping("upState")
    public String upStete(String card){
        System.out.println(card);
        CardEntity cardEntity = JSONObject.parseObject(card, CardEntity.class);

        cs.upState(cardEntity);
        return "OK";
    }

    //修改密码
    @RequestMapping("upCardPswd")
    public int upCardPswd(int NewcardPswd,String cardNo,int cardPswd){
        return cs.upCardPswd(NewcardPswd,cardNo,cardPswd);
    };
}
