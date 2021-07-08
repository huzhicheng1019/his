package cn.gson.his.model.service.wjc;

import cn.gson.his.model.mappers.wjc.CardMapper;
import cn.gson.his.model.pojos.wjc.CardEntity;
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
    //修改就诊卡
    @Transactional
    public void UpCard(CardEntity card){
        cm.upCard(card);
    }
}
