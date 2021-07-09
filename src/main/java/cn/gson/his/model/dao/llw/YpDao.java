package cn.gson.his.model.dao.llw;

import cn.gson.his.model.pojos.llw.DrugEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YpDao extends CrudRepository<DrugEntity,Integer> {

}
