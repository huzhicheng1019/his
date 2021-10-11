package cn.gson.his.model.service.Power;

import cn.gson.his.model.mappers.Power.UserMapper;
import cn.gson.his.model.pojos.Power.UserInfo;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public UserInfo Login(UserInfo user){
        return mapper.Login(user);
    }

    public int resetUser(JSONArray choose, String s) {
        int p=mapper.resetUser(choose,s);
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
