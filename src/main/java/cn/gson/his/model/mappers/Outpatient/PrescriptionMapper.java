package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.PrescriptionEntity;
import cn.gson.his.model.pojos.Outpatient.SyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface PrescriptionMapper {

    //新增处方
    public int addPres(PrescriptionEntity presc);


    //查询处方
    public PrescriptionEntity allPres(PrescriptionEntity presc);

    //查询所有要缴费的东西
    public List<SyEntity> allSy(String Record_id);


}
