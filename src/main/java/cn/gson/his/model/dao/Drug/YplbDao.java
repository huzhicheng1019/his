package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.LbEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YplbDao extends CrudRepository<LbEntity,Integer> {
}
