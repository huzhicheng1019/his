package cn.gson.his.model.mappers.llw;

import cn.gson.his.model.pojos.llw.DrugEntity;
import cn.gson.his.model.pojos.llw.GysEntity;
import cn.gson.his.model.pojos.llw.LbEntity;
import cn.gson.his.model.pojos.llw.LibraryxqEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface YpMapper {
    public List<DrugEntity> selectyp(DrugEntity drugEntity);

    public List<GysEntity> selectgys();

    public List<LbEntity> selectlb();

    public List<LibraryxqEntity> selectck(@Param("id") Integer id);
}
