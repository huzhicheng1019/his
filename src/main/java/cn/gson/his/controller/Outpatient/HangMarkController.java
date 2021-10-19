package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.Outpatient.CardEntity;
import cn.gson.his.model.pojos.Outpatient.HangmarkEntity;
import cn.gson.his.model.pojos.Outpatient.HangtypeEntity;
import cn.gson.his.model.pojos.Outpatient.PatientdataEntity;
import cn.gson.his.model.pojos.Power.Department;
import cn.gson.his.model.pojos.Power.Employee;
import cn.gson.his.model.service.Outpatient.CardService;
import cn.gson.his.model.service.Outpatient.HangMarkService;
import cn.gson.his.model.service.Outpatient.HangTypeService;
import cn.gson.his.model.service.Outpatient.PatientService;
import cn.gson.his.model.service.Power.DeparService;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private PatientService ps;
    //新增挂号
    @RequestMapping("addHangMark")
    public String addHangMark(String Hang){
        try {
            //通过json 把字符串修改成对象
            HangmarkEntity hang = JSONObject.parseObject(Hang, HangmarkEntity.class);
            Timestamp time2= new Timestamp(new Date().getTime());
            hang.setHangDate(time2);
            hms.addHang(hang);
            return  "OK";
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
            return  "NO";
        }

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
        hang.setHangState(0);
        return hms.seleHangMark(hang);
    }
    //查询患者有没有就诊卡
    @RequestMapping(value = "HangCard")
    public List<CardEntity> allCard(@RequestBody String patientNo){
        //用病人编号查询有没有就诊卡
            patientNo = patientNo.substring(0, patientNo.length()-1);
        CardEntity cardEntity = new CardEntity();
        cardEntity.setPati(new PatientdataEntity());
        cardEntity.getPati().setPatientNo(Integer.valueOf(patientNo));
        return cs.AllCard(cardEntity);
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
    //新增患者不新增就诊卡
    @RequestMapping("addPatieHang")
    public String addPatieHang(String hang){
       try {
           HangmarkEntity bankCardData = JSONObject.parseObject(hang, HangmarkEntity.class);
           //新增患者资料
           int i = ps.AddPtient(bankCardData.getPatie());
           //调用新增挂号的方法
           //挂号的时间
           Timestamp time2= new Timestamp(new Date().getTime());
           bankCardData.setHangDate(time2);
           //新增挂号里面的患者编号
           bankCardData.getPatie().setPatientNo(i);
           hms.addHang(bankCardData);
           return "OK";
       }catch (Exception e){
           System.out.println(e.fillInStackTrace());
           return "ON";
       }
    }
    //挂号的时候新增患者信息和就诊卡
    @RequestMapping("addCardPatie")
    public String addCardPatie(String hang){
        try {
            //新增患者然后再新增就诊卡和挂号
            //把病人资料新增
            HangmarkEntity bankCardData = JSONObject.parseObject(hang, HangmarkEntity.class);
            //新增患者资料
            int i = ps.AddPtient(bankCardData.getPatie());
            //新增就诊卡
            CardEntity card = new CardEntity();
            //默认密码123456
            card.setCardPswd("123456");
            //根据时间生成就诊卡号
            Date date = new Date();//获取当前的日期
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String str = df.format(date);//获取String类型的时间
            String response = str.replaceAll("[[\\s-:punct:]]","");
            card.setCardNo(response);
            //余额
            card.setCardPrice(0L);
            //预交金额
            card.setCardPrepay(0L);
            //病人姓名
            card.setPatientName(bankCardData.getPatie().getPatientName());
            //病人的编号
            card.setPatientNo(i);
            //就诊卡状态
            card.setCardState(1);
            //调用就诊卡新增方法
            cs.AddCard(card);
            //调用新增挂号的方法
            Timestamp time2= new Timestamp(new Date().getTime());
            bankCardData.setHangDate(time2);
            //就诊卡的患者编号
            bankCardData.getPatie().setPatientNo(i);
            hms.addHang(bankCardData);
            return response;
        }catch(Exception e){
            System.out.println(e.fillInStackTrace());
            return  "NO";
        }
    }
    //单独查询挂号记录
    @RequestMapping("DHangMark")
    public List<HangmarkEntity> DHangMark(@RequestBody Map<String,Object> datas){

        String date  =  (String)datas.get("value");
        String date1 = (String)datas.get("value1");
        String hang  =  (String)datas.get("input");
        return hms.seleHang(date,date1,hang);


    }
    //就诊里面的查询方法
    @RequestMapping("see_a_doctor")
    public List<HangmarkEntity>see_a_doctor(@RequestBody Map<String,Object> datas){
        HangmarkEntity hangmarkEntity = new HangmarkEntity();
        //主治医生
        hangmarkEntity.setDoctorName(new Employee());
        hangmarkEntity.getDoctorName().setEmpName((String) datas.get("empName"));
        //科室
        hangmarkEntity.setDepartment(new Department());
        hangmarkEntity.getDepartment().setDepaName((String) datas.get("deptName"));
        //状态
        hangmarkEntity.setHangState((int)datas.get("state"));
        return hms.seleHangMark(hangmarkEntity);
    }

}
