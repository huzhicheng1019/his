package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.OperationItemMapper;
import cn.gson.his.model.pojos.Checkout.OperationItemEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OperationItemService {
    @Autowired
    OperationItemMapper item;

    //查询所有能用的手术项目
    public List<OperationItemEntity> selItem(){
        return item.selItem();
    }


    //查询所有手术
    public List<OperationItemEntity> ItemAll(String content,String depaId){
        return item.ItemAll(content,depaId);
    }

    //新增手术项目
    public int insertItem(OperationItemEntity operationItemEntity){
        int i = item.insertItem(operationItemEntity);
        if(i>0){
            return 1;
        }
        return 0;
    }
    //修改手术项目
    public int updateItem(OperationItemEntity operationItemEntity){
        int i = item.updateItem(operationItemEntity);
        if(i>0){
            return 1;
        }
        return 0;
    }

    //根据手术项目id修改状态
    public int updateItemId(String operationZt,String operationId){
        int i = item.updateItemId(operationZt,operationId);
        if(i>0){
            return 1;
        }
        return 0;
    }
}
