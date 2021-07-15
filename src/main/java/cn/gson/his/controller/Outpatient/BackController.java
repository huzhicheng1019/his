package cn.gson.his.controller.Outpatient;


import cn.gson.his.model.pojos.Outpatient.BackEntity;
import cn.gson.his.model.service.Outpatient.BackService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* 退号
* */
@RestController
@CrossOrigin
public class BackController {
        @Autowired
        private BackService bs;

        //新增
        @RequestMapping("addBack")
        public void addBack(String back){
            BackEntity backEntity = JSONObject.parseObject(back, BackEntity.class);
            bs.seleBack(backEntity);
        }



}
