package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.OrderthEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CgthDao  extends CrudRepository<OrderthEntity,String> {
}
