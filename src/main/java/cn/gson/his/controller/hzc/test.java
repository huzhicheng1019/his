package cn.gson.his.controller.hzc;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class test {

    @RequestMapping("test")
    public String demo1(Integer empId){
        return "测试123";
    }
}
