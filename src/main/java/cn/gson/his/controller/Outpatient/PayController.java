package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.Outpatient.PayEntity;
import cn.gson.his.model.pojos.Outpatient.PaypartEntity;
import cn.gson.his.model.pojos.Outpatient.SyEntity;
import cn.gson.his.model.service.Outpatient.PayService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wjc")
public class PayController {

    @Autowired  PayService pat;

    //新增缴费和详情
    @RequestMapping("addPay")
    public int addPay(@RequestBody Map<String,Object> data){
        System.out.println("金额"+data.get("price"));
        //前端的缴费详情
        String  pay = JSONObject.toJSONString(data.get("pay"));
        //变成缴费详情
        List<SyEntity> syList = JSONObject.parseArray(pay, SyEntity.class);
        //获取缴费的人的名字
        String name = (String)data.get("name");

        System.out.println(data.get("pay"));
        PayEntity  payEntity = new PayEntity();
        //缴费时间
        payEntity.setPayDate(new Timestamp(new Date().getTime()));
        //就诊号
        payEntity.setRecordNo(Integer.valueOf(syList.get(0).getRecordId()));
        //缴费人姓名
        payEntity.setPayName(name);
        //费别
        payEntity.setPayType("无");
        //医保
        payEntity.setPayProtect(0);
        //金额
        Integer price = (Integer)data.get("price");
        payEntity.setPayPrice(Long.valueOf(price));
        //费用合计
        payEntity.setPayTotal(Long.valueOf(price));
        //缴费详情

        List<PaypartEntity> paypart = new ArrayList<>();
        syList.forEach(d->{
            PaypartEntity paypartEntity = new PaypartEntity();
            paypartEntity.setDrugName(d.getName());
            paypartEntity.setDrugQuantity(d.getCount());
            paypartEntity.setDrugPrice(Long.valueOf(d.getPrice()));
            paypart.add(paypartEntity);
        });
        paypart.forEach(d->{
            System.out.println(d.getDrugName());
        });
        //判断他修改的是处方还是检查检验
        String type = (String)data.get("type");
        pat.addPay(payEntity,paypart,type);
        return 1;
    }
    //查询缴费
    @RequestMapping("allPay")
    public List<PayEntity> allPay(String payDate, String payName,String recordNo){
        return pat.allPay(payDate,payName,recordNo);

    };

}
