package cn.gson.his.controller.InHospital;

import cn.gson.his.model.pojos.InHospital.CancelOperationEntity;
import cn.gson.his.model.pojos.InHospital.OperationApplyEntity;
import cn.gson.his.model.pojos.InHospital.OperationApplysEntity;
import cn.gson.his.model.service.InHospital.OperationApplyService;
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
public class OperationApplyController {

    @Autowired
    OperationApplyService applyService;

    //新增手术申请表和详情表
    @RequestMapping("/insertApp")
    public int demo(@RequestBody OperationApplyEntity OperationApp){

        int i =  applyService.insertApp(OperationApp);
        if(i>0){
            return 1;
        }
        return 0;
    }

    //查询手术申请表
    @RequestMapping("/selApp")
    public List<OperationApplyEntity> demo1(String regMark){
        return applyService.selApp(regMark);
    }



    //新增取消手术申请记录表 和 修改 手术申请详表状态
    @RequestMapping("/insertCan")
    public int demo2(String can, String appsId){
        CancelOperationEntity can1 = JSONObject.parseObject(can, CancelOperationEntity.class);

        System.out.println(can);
        System.out.println(appsId);
        return applyService.update(can1,appsId);
    }


    //查询所有手术申请表
    @RequestMapping("/allApp")
    public List<OperationApplyEntity> allApp(String operationApplyEntity){
        OperationApplyEntity operationApplyEntity1 = JSONObject.parseObject(operationApplyEntity, OperationApplyEntity.class);
        return  applyService.allApp(operationApplyEntity1);
    }

    //根据住院号查询病人已完成手术的申请表
    @RequestMapping("/selAppResult")
    public List<OperationApplyEntity> selAppResult(String regMark){
        return applyService.selAppResult(regMark);
    }

}
