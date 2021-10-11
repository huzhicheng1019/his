package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.ReturnPremiumMapper;
import cn.gson.his.model.pojos.Outpatient.ReturnPremiumEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnPremiumService {

    @Autowired ReturnPremiumMapper returnPremiumMapper;

    //新增一个退费表
    public int  insertReturn(ReturnPremiumEntity returnPremiumEntity){

                return returnPremiumMapper.insertReturn(returnPremiumEntity);
    }
    //查询退费表
    public List<ReturnPremiumEntity> seleReturn(ReturnPremiumEntity returnPremiumEntity){

        return  returnPremiumMapper.seleReturn(returnPremiumEntity);
    };
}
