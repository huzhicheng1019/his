package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.Outpatient.*;
import cn.gson.his.model.service.Outpatient.CheckoutService;
import cn.gson.his.model.service.Outpatient.ExamineService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wjc")
public class ExamineController {

    @Autowired
    ExamineService examineService;

    @Autowired
    CheckoutService checkoutService;


    @RequestMapping("addExamine")
    public int addExamine(@RequestBody Map<String,Object> data){

            //检查
            System.out.println(data.get("examine"));
            String json1 = JSONObject.toJSONString(data.get("examine"));
            List<ExamineEntity> examineEntity = JSONObject.parseArray(json1,ExamineEntity.class);
            examineEntity.forEach(d->{
                examineService.addExamine(d);
            });

            //检验
            System.out.println(data.get("checkout"));
            String json2 = JSONObject.toJSONString(data.get("checkout"));
            CheckoutEntity checkoutEntity = JSONObject.parseObject(json2,CheckoutEntity.class);

            //检验详情
            System.out.println(data.get("changepartEntities"));
            String json = JSONObject.toJSONString(data.get("changepartEntities"));
            List<ChangepartEntity> changepartEntity = JSONObject.parseArray(json,ChangepartEntity.class);
            checkoutService.addCheck(checkoutEntity,changepartEntity);


        return 1;
    }
    @RequestMapping("allExamineJF")
    public List<ExamineEntity> allExamineJF(String record_id){
        return  examineService.allExamineJF(record_id,1);
    }
    @RequestMapping("allExamineJGS")
    public List<ExamineEntity> allExamineJG(String checkoutId){
        return  examineService.allExamineJF(checkoutId,2);
    }


}
