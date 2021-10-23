package cn.gson.his.controller.Power;

import cn.gson.his.model.pojos.Power.ElMessage;
import cn.gson.his.model.pojos.Power.UserInfo;
import cn.gson.his.model.service.Power.UserService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
    @PostMapping("/login")
    public Object login(@RequestBody UserInfo user, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        UserInfo info = service.Login(user);
        if(info != null){
            return info;
        }else{
            return "fail";
        }
    }

    @PostMapping("/resetUser")
    public ElMessage resetUser(@RequestBody JSONArray choose) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        int p = service.resetUser(choose,"123456");
        ElMessage elm=new ElMessage();
        if(p>0){
            elm.setType("success");
            elm.setMessage("重置成功！");
        }
        return elm;
    }

    @RequestMapping("/userAccountIs")
    public int userAccountIs(String userAccount){
        return service.userAccountIs(userAccount);
    }

}
