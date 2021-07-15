package cn.gson.his.model.dao.llw;

import cn.gson.his.model.pojos.llw.ConEntity;
import cn.gson.his.model.pojos.llw.GysEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConDao extends CrudRepository<ConEntity,Integer> {

}
