package cn.gson.his.controller.InHospital;

import cn.gson.his.model.pojos.InHospital.BedExchangeEntity;
import cn.gson.his.model.service.InHospital.BedExchangeService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class BedExchangeController {
    @Autowired
    BedExchangeService bedExchangeService;

    //新增床位调换记录
    @RequestMapping("insertEx")
    public int demo(String bedExchange){
        BedExchangeEntity bedExchangeEntity = JSONObject.parseObject(bedExchange, BedExchangeEntity.class);

        return bedExchangeService.insertEx(bedExchangeEntity);

    }

    //查询床位调换记录
    @RequestMapping("/selBedExchange")
    public List<BedExchangeEntity> selBedExchange(String bedExchangeEntity){
        BedExchangeEntity bedExchangeEntity1 = JSONObject.parseObject(bedExchangeEntity, BedExchangeEntity.class);
        return bedExchangeService.selBedExchange(bedExchangeEntity1);
    }

}
