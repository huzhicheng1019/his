package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.StojlEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RkxqDao extends CrudRepository<StojlEntity,Integer> {
}
