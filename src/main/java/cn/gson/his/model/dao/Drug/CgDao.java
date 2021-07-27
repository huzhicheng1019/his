package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.LibraryInfoEntity;
import cn.gson.his.model.pojos.Drug.OrdersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CgDao extends CrudRepository<OrdersEntity,String> {
}
