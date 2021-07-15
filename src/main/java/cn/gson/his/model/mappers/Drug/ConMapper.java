package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.ConEntity;
import cn.gson.his.model.pojos.Drug.DrugEntity;
import cn.gson.his.model.pojos.Drug.GysEntity;
import cn.gson.his.model.pojos.Drug.LibraryxqEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface ConMapper {
    public List<ConEntity> concx(ConEntity conEntity);

    public List<LibraryxqEntity> selectck(@Param("id") Integer id);

    public List<GysEntity> selectgys();
}
