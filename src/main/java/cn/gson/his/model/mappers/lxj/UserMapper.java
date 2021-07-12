package cn.gson.his.model.mappers.lxj;

import cn.gson.his.model.pojos.lxj.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public UserInfo Login(UserInfo user);
}
