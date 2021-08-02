package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.Outpatient.PrescriptionEntity;
import cn.gson.his.model.pojos.Outpatient.PrescriptionsEntity;
import cn.gson.his.model.service.Outpatient.PrescriptionService;
import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("wjc")
public class PrescriptionController{
    @Autowired
    PrescriptionService prescriptionService;

    @RequestMapping("prescr")
    public int addPrescr(@RequestBody Map<String,Object> data){


        try {
            //处方
            LinkedHashMap prescription = (LinkedHashMap)data.get("prescription");
            String json1 = JSONObject.toJSONString(prescription);
            PrescriptionEntity prescriptionEntity = JSONObject.parseObject(json1,PrescriptionEntity.class);
            //新增生成处方时间
            prescriptionEntity.setPresDate(new Timestamp(new Date().getTime()));
            System.out.println(prescriptionEntity);
            //处方详情
            String json = JSONObject.toJSONString(data.get("drug"));
            List<PrescriptionsEntity> prescriptionsEntities = JSONObject.parseArray(json,PrescriptionsEntity.class);
            System.out.println(prescriptionsEntities);

            prescriptionService.addPres(prescriptionEntity,prescriptionsEntities);
            return 1;
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
            return 2;
        }


    }


}
