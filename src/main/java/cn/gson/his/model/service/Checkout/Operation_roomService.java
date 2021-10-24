package cn.gson.his.model.service.Checkout;



import cn.gson.his.model.mappers.Checkout.Operation_roomMapper;
import cn.gson.his.model.pojos.Checkout.OperationRoomEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class Operation_roomService {
    @Autowired
    Operation_roomMapper Operation_roomMapper;


    //查询所有手术室 带分页
    public List<OperationRoomEntity> selectroom(String name,String depaId){

        return Operation_roomMapper.selectroom(name,depaId);
    }

    //新增手术室
    public int insertroom(OperationRoomEntity operationRoomEntity){
        return Operation_roomMapper.insertroom(operationRoomEntity);
    }

    //根据id删除手术室
//    public void del(Integer id){
////        operation_roomDao.deleteById(id);
//    }

    //根据id禁用手术室
    public Integer delroom(Integer id){
        return Operation_roomMapper.delroom(id);
    }

    //根据id启用手术室
    public Integer updatezt(Integer id){
        return Operation_roomMapper.updatezt(id);
    }

    //根据Id编辑手术室
    public Integer updateroom(OperationRoomEntity operationRoomEntity){
        return Operation_roomMapper.updateroom(operationRoomEntity);
    }

    //查询所有手术室
    public List<OperationRoomEntity> queryRoom(){
        return Operation_roomMapper.queryRoom();
    }
}
