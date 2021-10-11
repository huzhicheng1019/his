package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.PillsEntity;
import cn.gson.his.model.pojos.Drug.PillsYz;
import cn.gson.his.model.pojos.Drug.Pillsxq;
import cn.gson.his.model.pojos.InHospital.DoctorEnjoinEntity;
import cn.gson.his.model.pojos.InHospital.DoctorEnjoinsEntity;
import cn.gson.his.model.pojos.Outpatient.PrescriptionEntity;
import cn.gson.his.model.pojos.Outpatient.PrescriptionsEntity;
import cn.gson.his.model.pojos.Power.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface YfMapper {
    public List<PillsEntity> yfcx(String nr);

    public List<Pillsxq> yfxqcx(@Param("id") String id, @Param("nr") String nr);

    public List<PrescriptionsEntity> cfxqcx(@Param("id") Integer id);

    public PrescriptionEntity cfidcx(@Param("id") Integer id);

    public List<PillsYz> yzyfcx(String nr);

    public DoctorEnjoinEntity lsyzcx(Integer id);

    public List<Department>  kscx();

    public List<DoctorEnjoinsEntity> yzcx(Integer id);

    public List<PillsEntity> yflycx(@Param("fl") Integer fl,@Param("nr") String nr);
}
