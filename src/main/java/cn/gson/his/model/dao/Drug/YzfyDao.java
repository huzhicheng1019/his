package cn.gson.his.model.dao.Drug;

import cn.gson.his.model.pojos.Drug.PillsYz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YzfyDao extends CrudRepository<PillsYz,String> {
}
