package cn.gson.his.model.dao.lxj;

import cn.gson.his.model.pojos.lxj.RoleInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<RoleInfo,Integer> {
    
}
