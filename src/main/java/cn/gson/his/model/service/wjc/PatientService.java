package cn.gson.his.model.service.wjc;

import cn.gson.his.model.mappers.wjc.PatientMapper;
import cn.gson.his.model.pojos.wjc.PatientdataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//自动注入到spring中
@Transactional
//事务回滚
public class PatientService {
    @Autowired
    private PatientMapper pm;//患者资料mapper对象


    //查询患者资料
    public List<PatientdataEntity> allPatientByPage(PatientdataEntity patient){
            //接收患者资料数据
            List<PatientdataEntity> pati = pm.selePatient(patient);
            //返回患者资料集合
            return pati;
    }
    //新增患者资料
    @Transactional
    public void AddPtient(PatientdataEntity patient){
            pm.AddPatient(patient);
    }
    //修改患者资料
    @Transactional
    public void UpdatePtient(PatientdataEntity patient){
            pm.UpdatePatient(patient);
    }

}
