package cn.gson.his.model.dao.llw;

import cn.gson.his.model.pojos.llw.LibraryxqEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CankxqDao  extends CrudRepository<LibraryxqEntity,Integer> {
}
