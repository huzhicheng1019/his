package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.Allot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbDao extends CrudRepository<Allot,Integer> {
}
