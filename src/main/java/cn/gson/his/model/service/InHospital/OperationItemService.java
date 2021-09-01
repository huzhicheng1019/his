package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.OperationItemMapper;
import cn.gson.his.model.pojos.Checkout.OperationItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OperationItemService {
    @Autowired
    OperationItemMapper item;

    //查询所有手术项目
    public List<OperationItemEntity> selItem(){
        return item.selItem();
    }
}
