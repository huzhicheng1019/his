package cn.gson.his.model.dao.Power;

import cn.gson.his.model.pojos.Power.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleDao extends CrudRepository<Title,Integer> {

    /**
     * 根据部门id查询该部门的职称
     * @return
     */
    public List<Title> findAllBy();
}
