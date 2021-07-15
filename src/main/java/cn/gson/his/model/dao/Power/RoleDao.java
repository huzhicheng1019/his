package cn.gson.his.model.dao.Power;

import cn.gson.his.model.pojos.Power.RoleInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<RoleInfo,Integer> {
    
}
