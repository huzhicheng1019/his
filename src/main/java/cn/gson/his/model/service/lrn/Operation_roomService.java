package cn.gson.his.model.service.lrn;



import cn.gson.his.model.mappers.lrn.Operation_roomMapper;
import cn.gson.his.model.pojos.lrn.OperationRoomEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class Operation_roomService {
    @Autowired
    Operation_roomMapper Operation_roomMapper;

//    @Autowired
//    Operation_roomDao operation_roomDao;

    //查询所有手术室 带分页
    public PageInfo selectroom(Integer no, Integer size){
        PageHelper.startPage(no, size);
        List<OperationRoomEntity> list = Operation_roomMapper.selectroom();
        PageInfo<OperationRoomEntity> info=new PageInfo<>(list);
        return info;
    }

    //新增手术室
    public int insertroom(OperationRoomEntity operationRoomEntity){
        return Operation_roomMapper.insertroom(operationRoomEntity);
    }

    //根据id删除手术室
//    public void del(Integer id){
////        operation_roomDao.deleteById(id);
//    }

    //根据id删除手术室
    public Integer delroom(Integer id){
        return Operation_roomMapper.delroom(id);
    }
}
