package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.CaseHistoryPartiMapper;
import cn.gson.his.model.pojos.Outpatient.CaseHistoryEntity;
import cn.gson.his.model.pojos.Outpatient.CaseHistoryPartiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CaseHistoryPartiService {


    @Autowired
    private CaseHistoryPartiMapper chpm;

    //查询病历详情
    public List<CaseHistoryPartiEntity>allCaseHistoryX(CaseHistoryPartiEntity caseHistoryPartiEntity){
        return chpm.allCaseHistoryX(caseHistoryPartiEntity);
    }
    //新增病历
    @Transactional
    public int addCaseHistory(CaseHistoryPartiEntity caseHistoryPartiEntity){

        chpm.addCaseHistory(caseHistoryPartiEntity);
        return caseHistoryPartiEntity.getPartiNo();
    }
}
