package cn.gson.his.model.dao.lxj;

import cn.gson.his.model.pojos.lxj.Dept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptDao extends CrudRepository<Dept,Integer> {

    /**
     * 分页查询所有
     */
    @Query(value="select d from Dept d",
    countQuery = "select count(d) from Dept d")
    public Page<Dept> findAllBy(Pageable pageable);

    /**
     * 查询所有
     * @return
     */
    public List<Dept> findAllBy();
}
