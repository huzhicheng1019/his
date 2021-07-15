package cn.gson.his.model.dao.Power;

import cn.gson.his.model.pojos.Power.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeparDao extends CrudRepository<Department,Integer> {

    /**
     * 分页查询所有科室
     */
    @Query(value="select d from Department d left join d.dept",
            countQuery = "select count(d) from Department d")
    public Page<Department> findAllBy(Pageable pageable);
}
