package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.DoctorEnjoinMapper;
import cn.gson.his.model.pojos.InHospital.DoctorEnjoinEntity;
import cn.gson.his.model.pojos.InHospital.DoctorEnjoinsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DoctorEnjoinService {
    @Autowired
    DoctorEnjoinMapper doctorEnjoinMapper;

    //新增医嘱表
    public int insertEn(DoctorEnjoinEntity en){

        doctorEnjoinMapper.insertEn(en);

        List<DoctorEnjoinsEntity> doctorEnjoins = en.getAdvice();

        for (DoctorEnjoinsEntity d: doctorEnjoins) {
            d.setEnId(en.getEnId());
        }

        return doctorEnjoinMapper.insertEns(doctorEnjoins);

    }



    //根据住院号查医嘱
    public List<DoctorEnjoinEntity> selEn(String regMark){
        return doctorEnjoinMapper.selEn(regMark);
    };

    //修改医嘱状态连着详表一起修改
    public int updateEn(String enId){
        doctorEnjoinMapper.updateEn(enId);
       return doctorEnjoinMapper.updateEns(enId);
    }

    //单独修医嘱详表状态
    public int upEns(String ensId){
        return doctorEnjoinMapper.upEns(ensId);
    }


}
