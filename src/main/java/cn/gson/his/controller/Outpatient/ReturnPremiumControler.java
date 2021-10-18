package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.Drug.Premium;
import cn.gson.his.model.pojos.Drug.Premiums;
import cn.gson.his.model.pojos.Outpatient.ReturnPremiumEntity;
import cn.gson.his.model.service.Outpatient.PremiumsService;
import cn.gson.his.model.service.Outpatient.ReturnPremiumService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("wjc")
public class ReturnPremiumControler {

    @Autowired  ReturnPremiumService returnPremiumService;
    @Autowired PremiumsService premiumsService;

     @RequestMapping("addreturnPremium")
     public int  insertReturn(String  returnPremiumEntity){
//
            long price = 0;
            ReturnPremiumEntity returnPremiumEntity2 = JSONObject.parseObject(returnPremiumEntity,ReturnPremiumEntity.class);
            Timestamp time2= new Timestamp(new Date().getTime());
            //把申请详情里面的金额算出来
            List<Premiums> returnPremiumEntities = premiumsService.selectPremiums(returnPremiumEntity2.getPremiumId());
            for (Premiums d: returnPremiumEntities) {
                price += d.getDrugPrice() * d.getCount();
            }
            returnPremiumEntity2.setReturnData(time2);
            returnPremiumEntity2.setReturnPrice(price);
            System.out.println(returnPremiumEntity);
            return  returnPremiumService.insertReturn(returnPremiumEntity2);
     }


}
