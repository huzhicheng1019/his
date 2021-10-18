package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.BedExchangeMapper;
import cn.gson.his.model.pojos.InHospital.BedExchangeEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BedExchangeService {
    @Autowired
    BedExchangeMapper bedExchangeMapper;

    //新增床位调换表
    public int insertEx(BedExchangeEntity bedExchange){
        return bedExchangeMapper.insertEx(bedExchange);
    };

    //查询床位调换记录
    public List<BedExchangeEntity> selBedExchange(BedExchangeEntity bedExchangeEntity){
        String beginTime = null;
        String endTime = null;
        String depaId = "";
        if (bedExchangeEntity.getBeginTime() != null && bedExchangeEntity.getEndTime() != null ) {
            SimpleDateFormat sf = new SimpleDateFormat("yyy-MM-dd");
            beginTime = sf.format(bedExchangeEntity.getBeginTime());
            endTime = sf.format(bedExchangeEntity.getEndTime());
        }

        if(bedExchangeEntity.getDepaId() != null){
            depaId = bedExchangeEntity.getDepaId()+"";
        }

        return bedExchangeMapper.selBedExchange(depaId,beginTime,endTime,bedExchangeEntity.getContent());

    };
}
