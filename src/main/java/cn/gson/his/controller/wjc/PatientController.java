package cn.gson.his.controller.wjc;
/*
患者资料Controller层
 */

import cn.gson.his.model.pojos.wjc.PatientdataEntity;
import cn.gson.his.model.service.wjc.PatientService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
public class PatientController {
    //患者资料Service层
    @Autowired
    private PatientService ps;

    //分页查询患者资料
    @RequestMapping("allpati")
    public List<PatientdataEntity> getPati(String pati){
        //通过json 把字符串修改成对象
        PatientdataEntity bankCardData = JSONObject.parseObject(pati, PatientdataEntity.class);
        //数据返回给前端
        return  ps.allPatientByPage(bankCardData);

    }
    //新增患者资料
    @RequestMapping("AddPati")
    public String Addpati(String pati){
        try {
            PatientdataEntity bankCardData = JSONObject.parseObject(pati, PatientdataEntity.class);
            ps.AddPtient(bankCardData);
           return "OK";
        }catch (Exception e){
            System.out.println("患者资料新增失败");
            return"NO";
        }
    }
    //修改患者资料
    @RequestMapping("UpPati")
    public String UpPati(String pati){
        try {
            PatientdataEntity bankCardData = JSONObject.parseObject(pati, PatientdataEntity.class);
            ps.UpdatePtient(bankCardData);
            return "OK";
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
            System.out.println("患者资料修改失败");
            return"NO";
        }
    }
}