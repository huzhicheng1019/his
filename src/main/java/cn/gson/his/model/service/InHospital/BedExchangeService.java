package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.BedExchangeMapper;
import cn.gson.his.model.pojos.InHospital.BedExchangeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BedExchangeService {
    @Autowired
    BedExchangeMapper bedExchangeMapper;

    //新增床位调换表
    public int insertEx(BedExchangeEntity bedExchange){
        return bedExchangeMapper.insertEx(bedExchange);
    };
}
