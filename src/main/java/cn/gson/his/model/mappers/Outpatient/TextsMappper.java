package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Checkout.TestsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TextsMappper {

    //查询检验检查
    public List<TestsEntity> selectTest(@Param("typeName") String typeName, @Param("jycx")String jycx);
}
