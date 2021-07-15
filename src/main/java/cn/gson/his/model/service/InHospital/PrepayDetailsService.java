package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.PrepayDetailsMapper;
import cn.gson.his.model.pojos.InHospital.PrepayDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PrepayDetailsService {
    @Autowired
    PrepayDetailsMapper prepayDetails;

    //根据缴费表编号查缴费详情表
    public List<PrepayDetailsEntity> selPreDet(String preId){
        return prepayDetails.selPreDet(preId);
    };
    //新增缴费详情表
    public int insertPreDet(PrepayDetailsEntity prepayDetailsEntity){
        return prepayDetails.insertPreDet(prepayDetailsEntity);
    };
}
