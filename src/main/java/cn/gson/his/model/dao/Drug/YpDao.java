package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.DrugEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YpDao extends CrudRepository<DrugEntity,Integer> {

}
