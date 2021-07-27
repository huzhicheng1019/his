package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.StoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RkDao extends CrudRepository<StoEntity,Integer> {
}
