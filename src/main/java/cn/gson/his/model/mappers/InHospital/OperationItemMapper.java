package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.Checkout.OperationItemEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperationItemMapper {

    //查询所有医疗项目
    public List<OperationItemEntity> selItem();

}
