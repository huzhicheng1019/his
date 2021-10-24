package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.CardMapper;
import cn.gson.his.model.mappers.Outpatient.CardRecordMapper;
import cn.gson.his.model.pojos.Outpatient.CardEntity;
import cn.gson.his.model.pojos.Outpatient.CardrecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//自动注入到spring中
@Transactional
//事务回滚
public class CardService {

    @Autowired
    //它可以对类成员变量、方法及构造函数进行标注，让 spring 完成 bean 自动装配的工作
    private CardMapper cm;
    //就诊卡充值记录
    @Autowired
    private CardRecordMapper crm;

    //查询就诊卡
    public List<CardEntity> AllCard(CardEntity card){
        //调用mapper里面的增删改查
        return  cm.allCard(card);
    }
    //新增就诊卡
    @Transactional
    public void AddCard(CardEntity card){
        //调用mapper里面的增删改查
            cm.addCard(card);
    }
    //修改就诊卡的金额,新增就诊卡充值记录
    @Transactional
    public int UpCard(CardEntity card,CardrecordEntity cardrecord){
        //try {
            //修改就诊卡的值
            int i = cm.upCard(card);
            if (i != 0){
                //查询就诊卡的id给就诊卡记录用
                List<CardEntity> cardEntities = cm.allCard(card);
                cardrecord.setCardId(cardEntities.get(0).getCardId());
                //新增就诊卡记录
                System.out.println("jzk"+cardrecord);
                crm.addCardecord(cardrecord);
                return 1 ;
            }else {
                return 2 ;
            }
//        }catch (Exception e){
//            System.out.println(e.fillInStackTrace());
//            return "NO";
//        }
    }
    //检验化验生成的缴费单
    public int addCardJl(CardrecordEntity cardrecord,CardEntity cardEntity){
        int i = cm.upCard(cardEntity);
        if(i != 0){
            crm.addCardecord(cardrecord);
            return 1 ;
        }else {
            return 2 ;
        }
    }
    @Transactional
    public String upState(CardEntity card){
        cm.upCard(card);
        return "OK";
    }
    @Transactional
    public void upCardID(String cardID,String cardPswd){
        cm.upCardID(cardID,cardPswd);
    }

    //修改密码
    public int upCardPswd(int NewcardPswd,String cardNo,int cardPswd){
        return cm.upCardPswd(NewcardPswd,cardNo,cardPswd);
    };
}
