package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.PrescriptionsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//处方详情
@Mapper
public interface PrescriptionsMapper {
    //新增处方详情
    public int addprescs(PrescriptionsEntity presc);
    //查询处方详情
    public List<PrescriptionsEntity>allPrescs(PrescriptionsEntity presc);
}
