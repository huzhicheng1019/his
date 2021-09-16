package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TyMapper {
    public List<RefundEntity> tycx(String nr);

    public List<Refundxq> tyxqcx(@Param("id") String id, @Param("nr") String nr);

    public List<StojlEntity> stojllyid(String id);

    public List<RefundEntity> tycxid(String id);
}
