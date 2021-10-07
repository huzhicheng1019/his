package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.CaseHistoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CaseHistoryMapper{


    //查询
    public List<CaseHistoryEntity>allCaseHistory(CaseHistoryEntity caseHistoryEntity);
    //新增
    public int addCaseHistory(CaseHistoryEntity caseHistoryEntity);

    //跟据身份证查询
    public CaseHistoryEntity IdentityCaseHistory(String patientIdentity);

    //根据状态查询
    public List<CaseHistoryEntity> IdentityCaseHistoryState(String patientIdentity);
}
