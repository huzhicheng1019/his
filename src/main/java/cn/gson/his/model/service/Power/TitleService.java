package cn.gson.his.model.service.Power;

import cn.gson.his.model.dao.Power.TitleDao;
import cn.gson.his.model.pojos.Power.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TitleService {

    @Autowired
    TitleDao dao;

    /**
     * 根据部门id查询该部门的职称
     * @param id
     * @return
     */
    public List<Title> allDeptIdTitle(Integer id){
        return dao.findAllByDeptByTitDept_DeptId(id);
    }
}
