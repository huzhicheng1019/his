package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.OrdersEntity;
import cn.gson.his.model.pojos.Drug.OrderthEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CgthMapper {
    public List<OrderthEntity> cgthcx(String nr);


}
