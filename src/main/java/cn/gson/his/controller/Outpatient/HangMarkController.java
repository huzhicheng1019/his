package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.Outpatient.CardEntity;
import cn.gson.his.model.pojos.Outpatient.HangmarkEntity;
import cn.gson.his.model.pojos.Outpatient.HangtypeEntity;
import cn.gson.his.model.pojos.Outpatient.PatientdataEntity;
import cn.gson.his.model.pojos.Power.Department;
import cn.gson.his.model.service.Outpatient.CardService;
import cn.gson.his.model.service.Outpatient.HangMarkService;
import cn.gson.his.model.service.Outpatient.HangTypeService;
import cn.gson.his.model.service.Power.DeparService;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
/*
* 挂号
* */
public class HangMarkController {
    //挂号
    @Autowired
    private HangMarkService hms;

    //科室
    @Autowired
    private DeparService ds;
    @Autowired
    //就诊卡的service
    private CardService cs;
    //挂号类型
    @Autowired
    private HangTypeService hts;
    //主治医师


    //新增挂号
    @RequestMapping("addHangMark")
    public int addHangMark(String Hang){
        //通过json 把字符串修改成对象
        HangmarkEntity hang = JSONObject.parseObject(Hang, HangmarkEntity.class);
        Timestamp time2= new Timestamp(new Date().getTime());
        hang.setHangDate(time2);
        int i = hms.addHang(hang);
        return i;
    }
    //挂号信息查询
    @RequestMapping("allHangMark")
    public List<HangmarkEntity> allHangMark(){
        //通过json 把字符串修改成对象
        //HangmarkEntity hang = JSONObject.parseObject(Hang, HangmarkEntity.class);
        //生成挂号时间
        HangmarkEntity  hang = new HangmarkEntity();
        Timestamp time2= new Timestamp(new Date().getTime());
        hang.setHangDate(time2);
        return hms.seleHangMark(hang);
    }
    //查询患者有没有就诊卡
    @RequestMapping(value = "HangCard")
    public List<CardEntity> allCard(@RequestBody String patientNo){
        System.out.println("----------------------"+patientNo);
        patientNo = patientNo.substring(0, patientNo.length()-1);
        System.out.println("----------------------"+patientNo);
        CardEntity cardEntity = new CardEntity();
        cardEntity.setPati(new PatientdataEntity());
        cardEntity.getPati().setPatientNo(Integer.valueOf(patientNo));
        return cs.AllCard(cardEntity);
//        }catch (Exception e){
//            System.out.println(e.fillInStackTrace());
//
//        }
    }
    //科室返回前端
    @RequestMapping("Depar")
    public List<Department> allDepa(){
        return ds.allDeparmy();
    }
    //把挂号类型返回前端
    @RequestMapping("HangType")
    public List<HangtypeEntity> allHangType(){
        return  hts.allHangType();
    }

}
