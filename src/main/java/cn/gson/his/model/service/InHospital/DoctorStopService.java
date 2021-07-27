package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.DoctorStopMapper;
import cn.gson.his.model.pojos.InHospital.DoctorStopEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DoctorStopService {
    @Autowired
    DoctorStopMapper doctorStopMapper;

    //新增医嘱停用记录表
    public int insertStop(DoctorStopEntity doctorStop ){


        return doctorStopMapper.insertStop(doctorStop);
    }
}
