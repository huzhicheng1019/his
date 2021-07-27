package cn.gson.his.model.dao.Power;

import cn.gson.his.model.pojos.Power.Schedu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduDao extends CrudRepository<Schedu,Integer> {

}
