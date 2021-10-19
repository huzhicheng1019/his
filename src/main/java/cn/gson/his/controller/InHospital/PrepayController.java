package cn.gson.his.controller.InHospital;


import cn.gson.his.model.pojos.InHospital.PrepayDetailsEntity;
import cn.gson.his.model.pojos.InHospital.PrepayEntity;
import cn.gson.his.model.service.InHospital.PrepayService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class PrepayController {
        @Autowired
        PrepayService prepayService;

    //新增押金缴费表
    @RequestMapping("/insertPre")
    public void demo(String prepay,String prepayDetail){
        PrepayEntity prepayEntity = JSONObject.parseObject(prepay,PrepayEntity.class);
        PrepayDetailsEntity prepayDetailsEntity = JSONObject.parseObject(prepayDetail, PrepayDetailsEntity.class);

        try{
            prepayService.insertPre(prepayEntity,prepayDetailsEntity);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //查询所有押金表
    @RequestMapping("selPre")
    public List<PrepayEntity> demo1(String content,String depaId){
        return prepayService.selPre(content,depaId);
    }
}
