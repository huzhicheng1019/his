package cn.gson.his.controller.InHospital;

import cn.gson.his.model.pojos.InHospital.DoctorEnjoinEntity;
import cn.gson.his.model.pojos.InHospital.DoctorEnjoinsEntity;
import cn.gson.his.model.pojos.InHospital.DoctorExecuteEntity;
import cn.gson.his.model.service.InHospital.DoctorEnjoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class DoctorEnjoinController {
    @Autowired
    DoctorEnjoinService service;

    @RequestMapping("/insertEn")
    public int demo(@RequestBody DoctorEnjoinEntity doctorAdivce){
        int i = service.insertEn(doctorAdivce);
        if(i>0){
            return 1;
        }
        return 0;
    }

    //根据住院号查医嘱
    @RequestMapping("/selEn")
    public List<DoctorEnjoinEntity> demo1(String regMark){
        return service.selEn(regMark);
    };


    //修改医嘱状态连着详表一起修改
    @RequestMapping("/updateEn")
    public int demo2(String enId){
        return service.updateEn(enId);
    }

    //单独修医嘱详表状态
    @RequestMapping("/updateEns")
    public int demo3(String ensId,String regMark){
        return service.upEns(ensId,regMark);
    }

    //执行医嘱查询
    @RequestMapping("/execute")
    public List<DoctorEnjoinEntity> demo4(String regMark){
        return service.execute(regMark);
    }
    //查询当天的医嘱执行记录
    @RequestMapping("/queryRecord")
    public List<DoctorExecuteEntity> demo9(String text, String depaId){
        return service.queryRecord(text, depaId);
    }

    //确认执行医嘱  新增执行记录 并扣费
    @RequestMapping("/carryout")
    public int demo5(String regMark){
        return service.carryout(regMark);
    }


    //根据住院号查医嘱执行记录
    @RequestMapping("/regSel")
    public List<DoctorExecuteEntity> regSel(String regMark){
        return service.regSel(regMark);
    }

}
