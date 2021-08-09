package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.Allot;
import org.springframework.data.repository.CrudRepository;

public interface DbDao extends CrudRepository<Allot,Integer> {
}
