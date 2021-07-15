package cn.gson.his.model.mappers.llw;

import cn.gson.his.model.pojos.llw.DrugEntity;
import cn.gson.his.model.pojos.llw.LbEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface YplbMapper {
    public List<LbEntity> lbcx(LbEntity lbEntity);

    public List<DrugEntity> ypcx(@Param("id") Integer id);
}
