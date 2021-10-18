package cn.gson.his.model.mappers.Checkout;


import cn.gson.his.model.pojos.Checkout.OperationRoomEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Operation_roomMapper {
    ////查询所有手术室 带分页
    public List<OperationRoomEntity> selectroom(String name);

    //新增手术室
    public int insertroom(OperationRoomEntity operationRoomEntity);

    //根据id禁用手术室
    public Integer delroom(Integer id);

    //根据id启用手术室
    public Integer updatezt(Integer id);

    //根据Id编辑手术室
    public Integer updateroom(OperationRoomEntity operationRoomEntity);
}
