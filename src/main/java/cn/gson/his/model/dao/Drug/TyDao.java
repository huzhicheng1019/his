package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.RefundEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TyDao extends CrudRepository<RefundEntity,String> {
}
