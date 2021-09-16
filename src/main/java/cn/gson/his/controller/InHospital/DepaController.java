package cn.gson.his.controller.InHospital;

import cn.gson.his.model.pojos.InHospital.TransferEntity;
import cn.gson.his.model.pojos.Power.Department;
import cn.gson.his.model.service.InHospital.DepaSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class DepaController {

    @Autowired
    DepaSerivce serivce;


    //查询当天值班的医生
    @RequestMapping("selDuty")
    public List<Department> selDuty(Integer deparId){
        return serivce.selDuty(deparId);
    }

    //确认转科   修改住院登记表 新增转科记录 新增病历
    @RequestMapping("/tran")
    public int demo(@RequestBody TransferEntity transfer){
        int i = serivce.insertTr(transfer);
        if (i>0){
            return 1;
        }
        return 0;
    }
}
