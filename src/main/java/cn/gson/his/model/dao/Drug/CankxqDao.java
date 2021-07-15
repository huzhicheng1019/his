package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.LibraryxqEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CankxqDao  extends CrudRepository<LibraryxqEntity,Integer> {
}
