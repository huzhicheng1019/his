package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.OrdersEntity;
import cn.gson.his.model.pojos.Drug.PlanInfoEntity;
import cn.gson.his.model.pojos.Drug.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface CgjhMapper {
    public List<PlanInfoEntity> cgjhcx(@Param("nr") String nr,@Param("qssj") Date qssj,@Param("jssj") Date jssj,@Param("cgqssj") Date cgqssj,@Param("cgjssj") Date cgjssj);

    public List<ProductEntity> cgjhxqcx(@Param("id") String id, @Param("nr") String nr);

    public List<PlanInfoEntity> cgjhcxid(String id);

    public List<OrdersEntity> cgcx(String id);

    public List<PlanInfoEntity> cgjhdd(String nr);

    public List<ProductEntity> cgjhddxq(@Param("id") String id, @Param("gid") Integer gid);

}
