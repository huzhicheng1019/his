package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.ChecksEntity;
import cn.gson.his.model.pojos.Drug.Premiums;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiumsDao  extends CrudRepository<Premiums,Long> {
}
