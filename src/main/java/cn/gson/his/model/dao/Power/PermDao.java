package cn.gson.his.model.dao.lxj;

import cn.gson.his.model.pojos.lxj.Perm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermDao extends CrudRepository<Perm,Integer> {
}
