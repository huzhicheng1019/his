package cn.gson.his.model.dao.Drug;


import cn.gson.his.model.pojos.Drug.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CgjhxqDao extends CrudRepository<ProductEntity,Integer> {
}
