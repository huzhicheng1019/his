package cn.gson.his.model.dao.lxj;

import cn.gson.his.model.pojos.lxj.Department;
import cn.gson.his.model.pojos.lxj.Dept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeparDao extends CrudRepository<Department,Integer> {

    /**
     * 查询所有
     */
    @Query(value="select d from Department d left join d.dept",
            countQuery = "select count(d) from Department d")
    public Page<Department> findAllBy(Pageable pageable);
}
