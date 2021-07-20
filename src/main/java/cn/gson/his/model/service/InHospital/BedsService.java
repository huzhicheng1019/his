package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.BedsMapper;
import cn.gson.his.model.pojos.InHospital.BedsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BedsService {
    @Autowired
    BedsMapper bedsMapper;

    //新增床位使用记录
    public int insertBeds(BedsEntity beds){
        return bedsMapper.insertBeds(beds);
    };
    //新增床位使用记录
    public int insertBedsOne(BedsEntity beds){
        return bedsMapper.insertBedsOne(beds);
    };


    //修改床位使用记录
    public int updateBeds(BedsEntity beds){
        return bedsMapper.updateBeds(beds);
    };
}
