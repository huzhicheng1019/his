package cn.gson.his.model.mappers.llw;

import cn.gson.his.model.pojos.llw.LbEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YplbMapper {
    public List<LbEntity> lbcx();
}
