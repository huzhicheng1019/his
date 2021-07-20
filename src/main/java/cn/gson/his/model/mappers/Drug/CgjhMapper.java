package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.OrdersEntity;
import cn.gson.his.model.pojos.Drug.PlanInfoEntity;
import cn.gson.his.model.pojos.Drug.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CgjhMapper {
    public List<PlanInfoEntity> cgjhcx(String nr);

    public List<ProductEntity> cgjhxqcx(@Param("id") Integer id, @Param("nr") String nr);

    public List<PlanInfoEntity> cgjhcxid(Integer id);

    public List<OrdersEntity> cgcx(Integer id);
}
