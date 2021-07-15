package cn.gson.his.model.dao.llw;

import cn.gson.his.model.pojos.llw.LibraryInfoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CangkDao extends CrudRepository<LibraryInfoEntity,Integer> {
}
