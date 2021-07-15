package cn.gson.his.controller.wjc;

import cn.gson.his.model.pojos.wjc.BackEntity;
import cn.gson.his.model.pojos.wjc.CardEntity;
import cn.gson.his.model.pojos.wjc.CardrecordEntity;
import cn.gson.his.model.service.wjc.BackService;
import cn.gson.his.model.service.wjc.CardService;
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
