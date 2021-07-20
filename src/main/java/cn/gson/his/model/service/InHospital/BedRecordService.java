package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.BedRecordMapper;
import cn.gson.his.model.pojos.InHospital.BedRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BedRecordService {
    @Autowired
    BedRecordMapper bedRecordMapper;

    //新增床位停用记录
    public int insertRec(BedRecordEntity bedRecord){
        return bedRecordMapper.insertRec(bedRecord);
    };

}
