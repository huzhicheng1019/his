package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.mappers.Outpatient.DoctorrecordMapper;
import cn.gson.his.model.pojos.Outpatient.*;
import cn.gson.his.model.service.Outpatient.PrescriptionService;
import cn.gson.his.model.service.Outpatient.PrescriptionsService;
import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("wjc")
public class PrescriptionController{
    @Autowired
    PrescriptionService prescriptionService;
    //处方详情
    @Autowired
    PrescriptionsService prescriptionsService;
//    新增处方和详情
    @RequestMapping("prescr")
    public int addPrescr(@RequestBody Map<String,Object> data){

//       try {
            //处方
            LinkedHashMap prescription = (LinkedHashMap)data.get("prescription");
            String json1 = JSONObject.toJSONString(prescription);
            PrescriptionEntity prescriptionEntity = JSONObject.parseObject(json1,PrescriptionEntity.class);

            //新增生成处方时间
            prescriptionEntity.setPresDate(new Timestamp(new Date().getTime()));
            //收费状态变成0
            prescriptionEntity.setPriveType("0");
            System.out.println(prescriptionEntity);
            //处方详情
            System.out.println(data.get("drug"));
            String json = JSONObject.toJSONString(data.get("drug"));
            List<PrescriptionsEntity> prescriptionsEntities = JSONObject.parseArray(json,PrescriptionsEntity.class);
            System.out.println(prescriptionsEntities.get(0).getpType());
            //修改就诊的状态
            String state =(String)data.get("state");
            DoctorrecordEntity doctorr = new DoctorrecordEntity();
            doctorr.setAttState((String)data.get("state"));
            doctorr.setRecordNo(prescriptionEntity.getRecordId().getRecordNo());
            prescriptionService.addPres(prescriptionEntity,prescriptionsEntities,doctorr);
            return 1;
//        }catch (Exception e){
//            System.out.println(e.fillInStackTrace());
//            return 2;
//        }


    }
    //查询处方
    @RequestMapping("prescription")
    public PrescriptionEntity allPrescription(@RequestBody Map<String,Object> data){
        String p = (String)data.get("presto");
        //new 一个处方对象查询处方
        PrescriptionEntity pres =  new PrescriptionEntity();
        //new 一个就诊记录
        DoctorrecordEntity  doct = new DoctorrecordEntity();
        //
        PatientdataEntity patie = new  PatientdataEntity();

        doct.setRecordNo(Integer.valueOf(p));
        pres.setRecordId(doct);
        pres.setPatientNo(patie);
        return prescriptionService.allPres(pres);
    }
    //查询处方详情
     @RequestMapping("prescriptions")
    public List<PrescriptionsEntity> allPrescriptions(@RequestBody Map<String,Object> data){
        //new一个处方详情对象
         PrescriptionsEntity prescriptionsEntities = new PrescriptionsEntity();
//         给处方编号赋值
         prescriptionsEntities.setPresId(new PrescriptionEntity());
            String id = (String) data.get("presto");
         prescriptionsEntities.getPresId().setPresNo(Integer.valueOf(id));
        return  prescriptionsService.allPrescs(prescriptionsEntities);
     };
    //查询所有要缴费的单
    @RequestMapping("sy")
    public List<SyEntity> allSy(@RequestBody Map<String,Object> data){
        String id = (String)data.get("presto");
        String state = (String)data.get("state");
        return prescriptionService.allSy(id,Integer.valueOf(state));
    }
    //查询所有要缴费的单
    @RequestMapping("jy")
    public List<SyEntity> allJc(@RequestBody Map<String,Object> data){
        String id = (String)data.get("presto");
        return prescriptionService.allJC(id);
    }
    //查询这个患者所有的化验检验
    @RequestMapping("SyPrescrip")
    public List<SyEntity> SyPrescrip(String recordid){
        System.out.println(recordid);
        return prescriptionService.SyPrescrip(recordid);
    }
    //查询患者要缴费的手术
    @RequestMapping("ss")
    public List<SyEntity> allOperall(@RequestBody Map<String,Object> data){
        String id = (String)data.get("presto");
        return prescriptionService.allOperall(id);
    }
    //查询这个患者所有的化验检查
    @RequestMapping("sllSYEexamineChange")
    public List<SyEntity>sllSYEexamineChange(String record_id){
        return prescriptionService.sllSYEexamineChange(record_id);
    }

}
