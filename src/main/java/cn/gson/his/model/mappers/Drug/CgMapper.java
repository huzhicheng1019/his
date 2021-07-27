package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.*;
import cn.gson.his.model.pojos.Power.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CgMapper {
    public List<OrdersEntity> cgcx(String nr);

    public List<OrderxqEntity> cgxqcx(@Param("id") String id, @Param("nr") String nr);

    public List<OrderxqEntity> cgxqfl(@Param("id") String id, @Param("fl") Integer fl);

    public List<OrdersEntity> cgcxid(String id);

    public List<Employee> empcx();

    public List<StoEntity> stocx(String id);
}
