package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.PayMapper;
import cn.gson.his.model.mappers.Outpatient.PayPartMappers;
import cn.gson.his.model.pojos.Outpatient.PayEntity;
import cn.gson.his.model.pojos.Outpatient.PaypartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;


@Service
@Transactional
public class PayService {
    //新增缴费单
    @Autowired PayMapper payEntity;
    //新增缴费详情
    @Autowired  PayPartMappers payPartMappers;
    //修改处方状态
    @Autowired PrescriptionService prescriptionService;
    //检查
    @Autowired ExamineService examineService;
    //化验
    @Autowired CheckoutService checkoutService;

    //手术
    @Autowired OperationApplyMZService operationApplyMZService;
    @Transactional
    public int addPay(PayEntity pay, List<PaypartEntity> paypartEntity,String type){

//        try {
            //缴费单
            payEntity.addPay(pay);

            //缴费详情
            paypartEntity.forEach(d->{
                PayEntity payEntity1 = new PayEntity();
                payEntity1.setPayNo(pay.getPayNo());
                d.setPayNo(payEntity1);
                payPartMappers.addPayPart(d);
            });
        System.out.println(type.equals("检查"));
        System.out.println(type.equals("处方"));
            if(type.equals("处方")){
                //修改处方收费状态
                prescriptionService.upPres(1,pay.getRecordNo());
            }else if(type.equals("手术")){
                paypartEntity.forEach(d->{
                    operationApplyMZService.upApply(2,""+d.getDrugQuantity());
                });

            }else{
//                    修改检查
                examineService.upExamine("1",""+pay.getRecordNo());
//                    修改检验
                checkoutService.upCheck(1,""+pay.getRecordNo());
            }

            return 0;
//        }catch (Exception e){
//            return  1;
//        }
    };
    //查询缴费记录
    public List<PayEntity> allPay(String payDate, String payName, String recordNo){
        return payEntity.allPay(payDate,payName,recordNo);
    };
}
