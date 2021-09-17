package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.ChecksEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdDao extends CrudRepository<ChecksEntity,String> {
}
