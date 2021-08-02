package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.DrugMapper;
import cn.gson.his.model.mappers.InHospital.LbMapper;
import cn.gson.his.model.pojos.Drug.DrugEntity;
import cn.gson.his.model.pojos.Drug.LbEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DrugService {

    @Autowired
    DrugMapper drugMapper;

    @Autowired
    LbMapper lbMapper;



    //查询所有药品
    public List<DrugEntity> selDrug(String typeId,String drugText){
        return drugMapper.selDrug(typeId,drugText);
    };


    //查询分类
    public List<LbEntity> selLb(String lbFl){
        return lbMapper.selLb(lbFl);
    }
}
