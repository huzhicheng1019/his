package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.DrugEntity;
import cn.gson.his.model.pojos.Drug.GysEntity;
import cn.gson.his.model.pojos.Drug.LbEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YpMapper {
    public List<DrugEntity> selectyp(DrugEntity drugEntity);

    public List<GysEntity> selectgys();

    public List<LbEntity> selectlb();

}
