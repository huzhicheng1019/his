package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.ChuEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChukDao extends CrudRepository<ChuEntity,Integer> {
}
