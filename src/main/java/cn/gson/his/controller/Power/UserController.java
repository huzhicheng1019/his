package cn.gson.his.controller.Power;

import cn.gson.his.model.pojos.Power.UserInfo;
import cn.gson.his.model.service.Power.UserService;
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

    /**
     * 登录
     * @param user
     * @param session
     * @return
     */
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
