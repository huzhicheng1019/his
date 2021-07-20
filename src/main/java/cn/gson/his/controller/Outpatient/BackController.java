package cn.gson.his.controller.Outpatient;


import cn.gson.his.model.pojos.Outpatient.BackEntity;
import cn.gson.his.model.pojos.Outpatient.HangmarkEntity;
import cn.gson.his.model.service.Outpatient.BackService;
import cn.gson.his.model.service.Outpatient.HangMarkService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/*
* 退号
* */
@RestController
@CrossOrigin
public class BackController {
        @Autowired
        private BackService bs;
        @Autowired
        private HangMarkService hms;
        //新增
        @RequestMapping("addBack")
        public void addBack(String back,String hang){
            //选中的挂号信息
            HangmarkEntity hangMark = JSONObject.parseObject(hang,HangmarkEntity.class);
            //退号表
            BackEntity backEntity = JSONObject.parseObject(back, BackEntity.class);
            //把挂号信息的id给退号记录
            backEntity.setHangId(hangMark.getHangNo());
            //获取当前时间
            Timestamp time2= new Timestamp(new Date().getTime());
            backEntity.setBackDate(time2);
            //新增退号
            bs.addBack(backEntity);
            HangmarkEntity hangmarkEntity = new HangmarkEntity();
            //根据编号
            hangmarkEntity.setHangNo(hangMark.getHangNo());
            //修改的状态
            hangmarkEntity.setHangState(3);
            //修改挂号信息状态
            hms.upState(hangmarkEntity);
        }



}
