package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.ChuEntity;
import cn.gson.his.model.pojos.Drug.PillsEntity;
import cn.gson.his.model.pojos.Drug.Pillsxq;
import cn.gson.his.model.pojos.Drug.StojlEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TyMapper {
    public List<PillsEntity> tycx(String nr);

    public List<Pillsxq> tyxqcx(@Param("id") String id, @Param("nr") String nr);

    public List<StojlEntity> stojllyid(String id);
}
