package cn.gson.his.model.mappers.llw;

import cn.gson.his.model.pojos.llw.DrugEntity;
import cn.gson.his.model.pojos.llw.GysEntity;
import cn.gson.his.model.pojos.llw.LbEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface YpMapper {
    public List<DrugEntity> selectyp();

    public List<GysEntity> selectgys();

    public List<LbEntity> selectlb();

}
