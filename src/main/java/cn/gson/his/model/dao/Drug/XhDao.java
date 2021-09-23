package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.Destroy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XhDao extends CrudRepository<Destroy,String> {
}
