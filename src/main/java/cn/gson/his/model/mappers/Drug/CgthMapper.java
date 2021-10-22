package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface CgthMapper {
    public List<OrderthEntity> cgthcx(String nr);

    public List<OrderthEntity> cgthglcx(@Param("nr") String nr, @Param("qssj") Date qssj, @Param("jssj") Date jssj);

    public List<OrderthxqEntity> cgthxqcx(@Param("id") String id, @Param("nr") String nr);

    public List<StojlEntity> stojllyid(@Param("id") String id);

    public List<OrderthEntity> cgthid(String id);

    public List<ChuEntity> chucx(String id);
}
