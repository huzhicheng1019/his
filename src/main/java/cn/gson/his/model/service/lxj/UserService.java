package cn.gson.his.model.service.lxj;

import cn.gson.his.model.mappers.lxj.UserMapper;
import cn.gson.his.model.pojos.lxj.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired
    UserMapper mapper;

    public UserInfo Login(UserInfo user){
        return mapper.Login(user);
    }
}
