package cn.gson.his.model.dao.Power;

import cn.gson.his.model.pojos.Power.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<UserInfo,Integer> {
}
