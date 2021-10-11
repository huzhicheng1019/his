package cn.gson.his.model.mappers.Power;

import cn.gson.his.model.pojos.Power.Employee;
import cn.gson.his.model.pojos.Power.UserInfo;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 登录
     * @param user
     * @return
     */
    public UserInfo Login(UserInfo user);

    public int resetUser(@Param("choose") JSONArray choose,@Param("s") String s);

    List<UserInfo> userAccountIs(String userAccount);
}
