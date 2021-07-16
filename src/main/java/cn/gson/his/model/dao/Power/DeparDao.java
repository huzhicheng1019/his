package cn.gson.his.model.dao.Power;

import cn.gson.his.model.pojos.Power.Department;
import cn.gson.his.model.pojos.Power.Dept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface DeparDao extends CrudRepository<Department,Integer> {

    /**
     * 分页查询所有科室
     */
    @Query(value="select d from Department d left join d.dept",
            countQuery = "select count(d) from Department d")
    public Page<Department> findAllBy(Pageable pageable);

    /**
     * 根据部门id查询该部门的科室
     * @param id
     * @return
     */
    public List<Department> findAllByDept_DeptId(Integer id);
}
