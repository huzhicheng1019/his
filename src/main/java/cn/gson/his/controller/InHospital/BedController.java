package cn.gson.his.controller.InHospital;


import cn.gson.his.model.pojos.InHospital.BedEntity;
import cn.gson.his.model.pojos.InHospital.BedRecordEntity;
import cn.gson.his.model.service.InHospital.BedRecordService;
import cn.gson.his.model.service.InHospital.BedService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class BedController {
    @Autowired
    BedService bedService;

    @Autowired
    BedRecordService bedRecordService;

    //根据id查询所有床位
    @RequestMapping("/selBed")
    public List<BedEntity> demo(String roomId){
        return bedService.selectBed(roomId);
    }

    //新增床位
    @RequestMapping("/insertBed")
    public int demo1(String beds){
        BedEntity bedEntity = JSONObject.parseObject(beds, BedEntity.class);
        int i = bedService.insertBed(bedEntity);
        if(i>0){
            return 1;
        }
        return 0;
    }
    //修改床位
    @RequestMapping("/updateBed")
    public int demo2(String beds){
        BedEntity bedEntity = JSONObject.parseObject(beds, BedEntity.class);
        int i = bedService.updateBed(bedEntity);
        if(i>0){
            return 1;
        }
        return 0;
    }

    //新增床位使用记录
    @RequestMapping("/insertRec")
    public int demo3(String bedRecord){
        BedRecordEntity BedRec = JSONObject.parseObject(bedRecord, BedRecordEntity.class);
        int i = bedRecordService.insertRec(BedRec);
        if(i>0){
            return 1;
        }
        return 0;
    }

    //根据床位id查所属病房
    @RequestMapping("/selIdBed")
    public BedEntity demo4(String bedId){
        return bedService.selIdBed(bedId);
    }

    //修改床位状态
    @RequestMapping("/updateStatus")
    public int demo5(String bedIs,String bedId){
        return bedService.updateStatus(bedIs,bedId);
    }
}
