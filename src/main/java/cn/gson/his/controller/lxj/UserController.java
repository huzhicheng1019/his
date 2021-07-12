package cn.gson.his.controller.lxj;

import cn.gson.his.model.pojos.lxj.UserInfo;
import cn.gson.his.model.service.lxj.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("lxj")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("login")
    public Object login(@RequestBody UserInfo user, HttpSession session){
        UserInfo info = service.Login(user);
        if(info != null){
            return info;
        }else{
            return "fail";
        }
    }
}
