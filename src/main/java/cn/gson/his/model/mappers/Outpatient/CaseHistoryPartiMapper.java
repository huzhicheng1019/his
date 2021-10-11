package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.CaseHistoryPartiEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CaseHistoryPartiMapper {

//    查询
    public List<CaseHistoryPartiEntity>allCaseHistoryX(CaseHistoryPartiEntity caseHistoryPartiEntity);
//    新增
    public void addCaseHistory(CaseHistoryPartiEntity caseHistoryPartiEntity);
}
