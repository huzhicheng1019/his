package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.PillsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FyDao extends CrudRepository<PillsEntity,String> {
}
