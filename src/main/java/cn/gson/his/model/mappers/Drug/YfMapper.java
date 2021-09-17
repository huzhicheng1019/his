package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.PillsEntity;
import cn.gson.his.model.pojos.Drug.Pillsxq;
import cn.gson.his.model.pojos.Outpatient.PrescriptionEntity;
import cn.gson.his.model.pojos.Outpatient.PrescriptionsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface YfMapper {
    public List<PillsEntity> yfcx(String nr);

    public List<Pillsxq> yfxqcx(@Param("id") String id, @Param("nr") String nr);

    public List<PrescriptionsEntity> cfxqcx(@Param("id") Integer id);

    public PrescriptionEntity cfidcx(@Param("id") Integer id);
}
