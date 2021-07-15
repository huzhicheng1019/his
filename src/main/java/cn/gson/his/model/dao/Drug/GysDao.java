package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.GysEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GysDao extends CrudRepository<GysEntity,Integer> {

}
