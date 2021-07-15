package cn.gson.his.model.dao.lxj;

import cn.gson.his.model.pojos.lxj.Dept;
import cn.gson.his.model.pojos.lxj.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends CrudRepository<Employee,Integer> {

}
