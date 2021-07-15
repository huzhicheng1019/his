package cn.gson.his.model.mappers.Power;

import cn.gson.his.model.pojos.Power.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 登录
     * @param user
     * @return
     */
    public UserInfo Login(UserInfo user);
}
