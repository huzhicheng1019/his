package cn.gson.his.model.service.Power;

import cn.gson.his.model.mappers.Power.UserMapper;
import cn.gson.his.model.pojos.Power.UserInfo;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired
    UserMapper mapper;

    /**
     * 登录
     * @param user
     * @return
     */
    public UserInfo Login(UserInfo user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        UserInfo login = mapper.Login(user);
        boolean b=false;
        if(login!=null){
            b = MD5.validPassword(user.getUserPass(), login.getUserPass());
        }
        return b ? login:null;
    }

    public int resetUser(JSONArray choose, String s) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String encryptedPwd = MD5.getEncryptedPwd(s);
        int p=mapper.resetUser(choose,encryptedPwd);
        return p;
    }

    public int userAccountIs(String userAccount) {
        List<UserInfo> list= mapper.userAccountIs(userAccount);
        if(list.isEmpty()){
            return 1;
        }
        return 0;
    }
}
