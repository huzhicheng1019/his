package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.OrderthxqEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CgthxqDao extends CrudRepository<OrderthxqEntity,Integer> {
}
