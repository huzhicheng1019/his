package cn.gson.his.model.dao.lxj;

import cn.gson.his.model.pojos.lxj.DepartmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeparDao extends CrudRepository<DepartmentEntity,Integer> {

    /**
     * 查询所有
     */
    @Query(value="select d from DepartmentEntity d",
            countQuery = "select count(d) from DepartmentEntity d")
    public Page<DepartmentEntity> findAllBy(Pageable pageable);
}
