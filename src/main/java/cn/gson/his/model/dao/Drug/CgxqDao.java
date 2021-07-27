package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.OrderxqEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CgxqDao extends CrudRepository<OrderxqEntity,Integer> {
}
