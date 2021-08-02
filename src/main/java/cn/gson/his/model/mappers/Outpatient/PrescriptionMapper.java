package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.PrescriptionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface PrescriptionMapper {

    //新增处方
    public int addPres(PrescriptionEntity presc);


    //查询处方
    public List<PrescriptionEntity> allPres(PrescriptionEntity presc);



}
