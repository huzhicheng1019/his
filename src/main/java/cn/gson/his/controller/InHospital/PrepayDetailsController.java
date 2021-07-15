package cn.gson.his.controller.InHospital;

import cn.gson.his.model.pojos.InHospital.PrepayDetailsEntity;
import cn.gson.his.model.pojos.InHospital.PrepayEntity;
import cn.gson.his.model.service.InHospital.PrepayDetailsService;
import cn.gson.his.model.service.InHospital.PrepayService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class PrepayDetailsController {
    //押金详表
    @Autowired
    PrepayDetailsService prepayDetails;

    //押金表
    @Autowired
    PrepayService prepayService;

    //查询所有押金表
    @RequestMapping("selPreDet")
    public List<PrepayDetailsEntity> demo(String preId){

        return prepayDetails.selPreDet(preId);
    }

    //新增缴费详情表
    @RequestMapping("insertPreDet")
    public int demo1(String prepayDetailsEntity){
        PrepayDetailsEntity prepayDetailsEntity1 = JSONObject.parseObject(prepayDetailsEntity, PrepayDetailsEntity.class);

        //修改余额
        PrepayEntity pre = new PrepayEntity();
        pre.setPreBalance(prepayDetailsEntity1.getPresPrice());
        pre.setPreId(prepayDetailsEntity1.getPreId());
        prepayService.updatePre(pre);

        int i = prepayDetails.insertPreDet(prepayDetailsEntity1);
        if(i>0){
            return 1;
        }
        return 0;
    }
}
