package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.PayMapper;
import cn.gson.his.model.mappers.Outpatient.PayPartMappers;
import cn.gson.his.model.pojos.Outpatient.PayEntity;
import cn.gson.his.model.pojos.Outpatient.PaypartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PayService {
    //新增缴费单
    @Autowired PayMapper payEntity;
    //新增缴费详情
    @Autowired  PayPartMappers payPartMappers;
    //修改处方状态
    @Autowired PrescriptionService prescriptionService;
    @Transactional
    public int addPay(PayEntity pay, List<PaypartEntity> paypartEntity){
        try {
            //缴费单
            payEntity.addPay(pay);
            //缴费详情
            paypartEntity.forEach(d->{
                PayEntity payEntity1 = new PayEntity();
                payEntity1.setPayNo(pay.getPayNo());
                d.setPayNo(payEntity1);
                payPartMappers.addPayPart(d);
            });
            //修改处方收费状态
            prescriptionService.upPres(1,pay.getRecordNo());
            return 0;
        }catch (Exception e){
            return  1;
        }
    };
}
