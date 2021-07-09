package cn.gson.his.model.dao.llw;

import cn.gson.his.model.pojos.llw.LbEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YplbDao extends CrudRepository<LbEntity,Integer> {
}
