package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.HangtypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HangTypeMapper {

    public List<HangtypeEntity> allHangType();
}
