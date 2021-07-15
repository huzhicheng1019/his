package cn.gson.his.model.dao.Power;

import cn.gson.his.model.pojos.Power.Perm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermDao extends CrudRepository<Perm,Integer> {
}
