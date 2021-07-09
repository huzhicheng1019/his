package cn.gson.his.model.service.wjc;

import cn.gson.his.model.mappers.wjc.CardRecordMapper;
import cn.gson.his.model.pojos.wjc.CardrecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//事务回滚
@Transactional
public class CardRecordService {

    @Autowired
    private CardRecordMapper crm;

    //查询就诊卡充值记录
    public List<CardrecordEntity> allCardRecord(CardrecordEntity  cardrecord){
            return crm.allCardRecord(cardrecord);
    }
    //新增就诊卡
    @Transactional
    public int addCardecord(CardrecordEntity cardrecord){
        int i = crm.addCardecord(cardrecord);
        return  i;
    }
}
