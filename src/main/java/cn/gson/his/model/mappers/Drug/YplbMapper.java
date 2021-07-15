package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.LbEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YplbMapper {
    public List<LbEntity> lbcx();
}
