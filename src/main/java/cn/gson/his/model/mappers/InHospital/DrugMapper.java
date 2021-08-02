package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.Drug.DrugEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DrugMapper {
    //查询所有药品
    public List<DrugEntity> selDrug(@Param("typeId") String typeId,@Param("drugText") String drugText);
}
