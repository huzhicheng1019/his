package cn.gson.his.controller.InHospital;

import cn.gson.his.model.pojos.InHospital.DoctorStopEntity;
import cn.gson.his.model.service.InHospital.DoctorStopService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class DoctorStopController {
    @Autowired
    DoctorStopService doctorStopService;

    @RequestMapping("/insertStop")
    public int demo(String doctorStop){
        DoctorStopEntity doctorStopEntity = JSONObject.parseObject(doctorStop, DoctorStopEntity.class);

        return doctorStopService.insertStop(doctorStopEntity);
    }
}
