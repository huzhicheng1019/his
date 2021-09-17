package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.Checkxq;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdxqDao extends CrudRepository<Checkxq,Integer> {
}
