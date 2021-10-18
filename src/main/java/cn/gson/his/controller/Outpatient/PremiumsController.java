package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.Drug.Premium;
import cn.gson.his.model.pojos.Drug.Premiums;
import cn.gson.his.model.pojos.Outpatient.PrescriptionEntity;
import cn.gson.his.model.service.Outpatient.PremiumsService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wjc")
public class PremiumsController {

    @Autowired PremiumsService premiumsService;
    //查询主表
    @RequestMapping("selectPremium")
    public List<Premium> selectPremium(String premium1){

        Premium premium2 = JSONObject.parseObject(premium1,Premium.class);

        return premiumsService.selectPremium(premium2);
    };
    //查询详情
    @RequestMapping("selectPremiums")
    public List<Premiums>selectPremiums(String id){
        System.out.println(id);
        return premiumsService.selectPremiums(Integer.valueOf(id));
    };
    //修改状态
    @RequestMapping("upPremiums")
    public int upPremiums(){

        return premiumsService.upPremiums(1);
    };

}
