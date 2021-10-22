package cn.gson.his.controller.InHospital;

import cn.gson.his.model.pojos.Checkout.OperationItemEntity;
import cn.gson.his.model.pojos.InHospital.DoctorEnjoinEntity;
import cn.gson.his.model.service.InHospital.OperationItemService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class OperationItemController {
    @Autowired
    OperationItemService itemService;


    //查询所有能用的手术项目
    @RequestMapping("/selItem")
    public List<OperationItemEntity> demo(){
        return itemService.selItem();
    }

    //查询所有手术项目
    @RequestMapping("/ItemAll")
    public List<OperationItemEntity> demo1(String content,String depaId){
        return itemService.ItemAll(content,depaId);
    }

    //新增手术项目
    @RequestMapping("/insertItem")
    public int insertItem(String  operationItemEntity){
        OperationItemEntity operationItemEntity1 = JSONObject.parseObject(operationItemEntity, OperationItemEntity.class);
        return itemService.insertItem(operationItemEntity1);
    }
    //修改手术项目
    @RequestMapping("/updateItem")
    public int updateItem(String operationItemEntity){
        OperationItemEntity operationItemEntity1 = JSONObject.parseObject(operationItemEntity, OperationItemEntity.class);
        return itemService.updateItem(operationItemEntity1);
    }

    //根据手术项目id修改状态
    @RequestMapping("/updateItemId")
    public int updateItemId(String operationZt,String operationId){
        return itemService.updateItemId(operationZt,operationId);
    }

}
