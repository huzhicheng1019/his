package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.CaseHistoryMapper;
import cn.gson.his.model.pojos.Outpatient.CaseHistoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CaseHistoryService {
        @Autowired
        private CaseHistoryMapper chm;

        //查询病历
        public List<CaseHistoryEntity>allCaseHistory(CaseHistoryEntity caseHistoryEntity){
                return  chm.allCaseHistory(caseHistoryEntity);

        }
        @Transactional
        public int addCaseHistory(CaseHistoryEntity caseHistoryEntity){
                caseHistoryEntity.setCaseState(0);
                chm.addCaseHistory(caseHistoryEntity);
                //返回病历主键
                return caseHistoryEntity.getCaseHissstory();
        }

}
