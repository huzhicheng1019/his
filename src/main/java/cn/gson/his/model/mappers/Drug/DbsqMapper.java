package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.Allot;
import cn.gson.his.model.pojos.Drug.Allotxq;
import cn.gson.his.model.pojos.Drug.ProductEntity;
import cn.gson.his.model.pojos.Drug.StoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DbsqMapper {
    public List<Allot> dbcx(String nr);

    public List<Allotxq> dbxqcx(@Param("id") String id, @Param("nr") String nr);

    public List<Allot> dbxx(String id);

    public List<StoEntity> stocx(@Param("id") String id);
}
