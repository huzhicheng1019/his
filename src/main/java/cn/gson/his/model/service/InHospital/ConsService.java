package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.ConsMapper;
import cn.gson.his.model.pojos.Drug.ConEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ConsService {
    @Autowired
    ConsMapper consMapper;

    //查询所有耗材
    public List<ConEntity> selCon(String conText){
        return consMapper.selCon(conText);
    };


}
