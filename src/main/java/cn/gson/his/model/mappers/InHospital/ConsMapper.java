package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.Drug.ConEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConsMapper {
    //查询所有耗材
    public List<ConEntity> selCon(String conText);


}
