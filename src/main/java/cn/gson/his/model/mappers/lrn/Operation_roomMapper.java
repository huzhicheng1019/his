package cn.gson.his.model.mappers.lrn;

import cn.gson.his.model.pojos.lrn.OperationRoomEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface Operation_roomMapper {
    ////查询所有手术室 带分页
    public List<OperationRoomEntity> selectroom();

    //新增手术室
    public int insertroom(OperationRoomEntity operationRoomEntity);

    //根据id删除手术室
    public Integer delroom(Integer id);
}
