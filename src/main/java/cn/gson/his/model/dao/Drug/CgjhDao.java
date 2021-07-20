package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.PlanInfoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CgjhDao extends CrudRepository<PlanInfoEntity,Integer> {
}
