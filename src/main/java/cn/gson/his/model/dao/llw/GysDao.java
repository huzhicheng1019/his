package cn.gson.his.model.dao.llw;

import cn.gson.his.model.pojos.llw.GysEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GysDao extends CrudRepository<GysEntity,Integer> {

}
