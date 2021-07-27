package cn.gson.his.model.dao.Power;

import cn.gson.his.model.pojos.Power.Shift;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftDao extends CrudRepository<Shift,Integer> {
}
