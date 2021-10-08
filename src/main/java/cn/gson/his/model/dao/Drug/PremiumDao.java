package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.Premium;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiumDao  extends CrudRepository<Premium,String> {

}
