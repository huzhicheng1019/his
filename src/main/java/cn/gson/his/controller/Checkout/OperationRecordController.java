package cn.gson.his.controller.Checkout;

import cn.gson.his.model.pojos.Checkout.OperationRecordEntity;
import cn.gson.his.model.service.Checkout.OperationRecordService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/lrn")
@RestController
public class OperationRecordController {
    @Autowired
    OperationRecordService recordService;

    //新增手术记录（结果）表
    @RequestMapping("/insertRecord")
    public int insertRecord(String recordEntity){
        OperationRecordEntity operationRecordEntity = JSONObject.parseObject(recordEntity, OperationRecordEntity.class);

        return recordService.insertRecord(operationRecordEntity);
    }

    //修改手术记录（结果）表
    @RequestMapping("/updateRecord")
    public int updateRecord(String recordEntity){
        OperationRecordEntity operationRecordEntity = JSONObject.parseObject(recordEntity, OperationRecordEntity.class);
        System.out.println(operationRecordEntity);
        return recordService.updateRecord(operationRecordEntity);
    }

    //根据申请详情编号查记录
    @RequestMapping("/selectRecord")
    public OperationRecordEntity selectRecord(String operationId){
        return recordService.selectRecord(operationId);
    }
}
