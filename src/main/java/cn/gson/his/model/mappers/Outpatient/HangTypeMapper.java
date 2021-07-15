package cn.gson.his.model.mappers.wjc;

import cn.gson.his.model.pojos.wjc.HangtypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HangTypeMapper {

    public List<HangtypeEntity> allHangType();
}
