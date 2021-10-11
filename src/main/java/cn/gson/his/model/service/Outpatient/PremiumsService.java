package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.PremiumsMapper;
import cn.gson.his.model.pojos.Drug.Premium;
import cn.gson.his.model.pojos.Drug.Premiums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremiumsService {

    @Autowired  PremiumsMapper premiumsMapper;
    //查询主表
    public List<Premium> selectPremium(Premium premium){
        return premiumsMapper.selectPremium(premium);
    };
    //查询详情
    public List<Premiums> selectPremiums(Integer id){
        return  premiumsMapper.selectPremiums(id);
    };
    //修改状态
    public int upPremiums(int premiumsState){
        return premiumsMapper.upPremiums(premiumsState);
    };
}
