package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.Allotxq;
import cn.gson.his.model.pojos.Drug.Premium;
import cn.gson.his.model.pojos.Drug.Premiums;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TfMapper {
    public List<Premium> tfsqcx(String nr);

    public List<Premiums> tfsqxqcx(@Param("id") String id, @Param("nr") String nr);
}
