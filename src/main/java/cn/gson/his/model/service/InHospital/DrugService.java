package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.DrugMapper;
import cn.gson.his.model.pojos.Drug.DrugEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DrugService {

    @Autowired
    DrugMapper drugMapper;

    //查询所有药品
    public List<DrugEntity> selDrug(String drugText){
        return drugMapper.selDrug(drugText);
    };
}
