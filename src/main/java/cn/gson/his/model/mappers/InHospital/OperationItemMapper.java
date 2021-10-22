package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.Checkout.OperationItemEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OperationItemMapper {

    //查询所有能用的手术项目
    public List<OperationItemEntity> selItem();


    //查询所有手术项目
    public List<OperationItemEntity> ItemAll(@Param("content")String content, @Param("depaId") String depaId);

    //新增手术项目
    public int insertItem(OperationItemEntity operationItemEntity);

    //修改手术项目
    public int updateItem(OperationItemEntity operationItemEntity);

    //根据手术项目id修改状态
    public int updateItemId(@Param("operationZt")String operationZt,@Param("operationId")String operationId);
}
