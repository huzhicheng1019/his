package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.Outpatient.ChangepartEntity;
import cn.gson.his.model.pojos.Outpatient.SeleExamineCheckoutEntity;
import cn.gson.his.model.service.Outpatient.ChangepartService;
import cn.gson.his.model.service.Outpatient.CheckoutService;
import cn.gson.his.model.service.Outpatient.ExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wjc")
public class CheckoutController {

    @Autowired
    CheckoutService checkoutService;

    @Autowired
    ChangepartService changepartService;


    @Autowired
    ExamineService examineService;

    @RequestMapping("addChec")
    public int addCheck(Map<String,Object> data){

        return 1;
    }
    //查询缴费的化验单
    @RequestMapping("seleCheckJF")
    public List<ChangepartEntity> seleCheckJF(String checkoutId){
        return changepartService.seleCheckJF(checkoutId);
    }

    @RequestMapping("seleCheckJG")
    public List<ChangepartEntity> seleCheckJG(String checkoutId){
        return changepartService.allChangepartJG(checkoutId);
    }
    //查询所有有结果的检查化验
    @RequestMapping("ExamineCheckout")
    public List<SeleExamineCheckoutEntity> seleExamineCheckout(String checkoutId){
        return checkoutService.seleExamineCheckout(checkoutId);
    }

    //修改是否填写结果
    @RequestMapping("upChangepartJG")
    public int upChangepartJG(int state,int changepartNo){
        examineService.upExamineID(state+"",changepartNo);
        int i = changepartService.upChangepartJG(state, changepartNo);
        if(i>0){
            return 1;
        }
        return 0;
    }
}
