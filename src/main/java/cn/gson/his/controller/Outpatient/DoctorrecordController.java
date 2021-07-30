package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.Outpatient.CaseHistoryEntity;
import cn.gson.his.model.pojos.Outpatient.CaseHistoryPartiEntity;
import cn.gson.his.model.pojos.Outpatient.DoctorrecordEntity;
import cn.gson.his.model.pojos.Power.Department;
import cn.gson.his.model.pojos.Power.Employee;
import cn.gson.his.model.service.Outpatient.CaseHistoryPartiService;
import cn.gson.his.model.service.Outpatient.CaseHistoryService;
import cn.gson.his.model.service.Outpatient.DoctorrecordService;
import cn.gson.his.model.service.Outpatient.HangMarkService;
import com.alibaba.fastjson.JSONObject;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wjc")
public class DoctorrecordController {

    @Autowired
    private DoctorrecordService ds;
    //病历
    @Autowired
    private CaseHistoryService chs;
    //病历详情
    @Autowired
    private CaseHistoryPartiService chps;

    //就诊查询
    @RequestMapping("allDoctorr")
    public List<DoctorrecordEntity>allDoctorr(@RequestBody Map<String,Object> date){
        System.out.println(date);
        DoctorrecordEntity doctorrecordEntity = new DoctorrecordEntity();
        //就诊科室
        Department department = new Department();
        doctorrecordEntity.setRecordIndoor(department);
        doctorrecordEntity.getRecordIndoor().setDepaName((String)date.get("DepaName"));
        //主治医师
        doctorrecordEntity.setDoctor(new Employee());
        doctorrecordEntity.getDoctor().setEmpName((String)date.get("EmpName"));

        System.out.println("-------"+doctorrecordEntity.getDoctor().getEmpName());
        return ds.alldoctor(doctorrecordEntity);
    }
    //查询就诊记录
    @RequestMapping("allDoct")
    public List<DoctorrecordEntity> allDoct(@RequestBody Map<String,Object> date) {
        //获取前端下拉框的值判断用户怎么查
        System.out.println(date);
        String select = (String)date.get("select");
        //new 就诊记录的对象
        DoctorrecordEntity doctorrecordEntity = new DoctorrecordEntity();

        if(select == ""){
            return ds.allDoctorrecord(doctorrecordEntity);
        }else if(select.equals("患者姓名")){
            doctorrecordEntity.setRecordName((String) date.get("input"));
        }else if (select.equals("就诊号")){
            String i =  (String) date.get("input");
            if(i.equals("")){
                return ds.allDoctorrecord(doctorrecordEntity);
            }else{
                doctorrecordEntity.setRecordNo(Integer.parseInt(i));
            }

        }else{
            doctorrecordEntity.setRecordIdentity((String)date.get("input"));
        }
        return ds.allDoctorrecord(doctorrecordEntity);
    }
    //新增就诊记录和病历
    @RequestMapping("addDoctorrecord")
    public int addDoctorrecord(@RequestBody Map<String,Object> date){
        System.out.println(date);
        //获取病历
        LinkedHashMap caseHis = (LinkedHashMap)date.get("caseNo");
        String caseHistory = JSONObject.toJSONString(caseHis);
        CaseHistoryEntity caseHistory1 = JSONObject.parseObject(caseHistory,CaseHistoryEntity.class);

        //获取病历详情对象
        LinkedHashMap CaseHistory  = (LinkedHashMap)date.get("CaseHistoryParti");
        String CaseHistoryParti = JSONObject.toJSONString(CaseHistory);
        CaseHistoryPartiEntity caseHistoryPar = JSONObject.parseObject(CaseHistoryParti,CaseHistoryPartiEntity.class);

        //获取就诊记录对象
        LinkedHashMap docto  = (LinkedHashMap)date.get("form");
        String doctorrecord = JSONObject.toJSONString(docto);
        DoctorrecordEntity doctorrecordEntity = JSONObject.parseObject(doctorrecord, DoctorrecordEntity.class);

        //修改挂号状态根据编号
        Integer state =(int)date.get("state");
        Integer HnagNo = (int)date.get("hangNo");
        ds.addDoctorrecord(doctorrecordEntity,caseHistory1,caseHistoryPar,state,HnagNo);
        //先新增病历详情
        return 1;
    }
}
