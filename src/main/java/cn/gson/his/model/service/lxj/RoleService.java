package cn.gson.his.model.service.lxj;

import cn.gson.his.model.mappers.lxj.RoleMapper;
import cn.gson.his.model.pojos.lxj.Dept;
import cn.gson.his.model.pojos.lxj.RoleDeptPK;
import cn.gson.his.model.pojos.lxj.RoleInfo;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleService {

    @Autowired
    RoleMapper mapper;

    /**
     * 分页查询所有
     * @param pageNo
     * @param size
     * @return
     */
    public Map<String, Object> allRole(Integer pageNo,Integer size){
        Page<Object> p = PageHelper.startPage(pageNo,size);
        List<Map<String,Object>> list = mapper.allRole();
        Map<String,Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",p.getTotal());
        return map;
    }

    /**
     * 查询角色、部门中间表，根据中间表的角色id查询所有部门
     * @param id
     * @return
     */
    public List<Dept> allRoleDept(Integer id){
        return mapper.allRoleDept(id);
    }

    /**
     * 查询序列
     * @return
     */
    public Integer allSeq(){
        return mapper.allSeq();
    }

    /**
     * 查询所有角色
     * @return
     */
    public List<RoleInfo> allRoleMy(){
        return mapper.allRoleMy();
    }

    /**
     * 新增、修改角色
     * @param roleInfo
     * @param id
     * @param list
     * @param is
     * @return
     */
    public int addRole(RoleInfo roleInfo,Integer id, List<RoleDeptPK> list,boolean is){
        int p=-1;//判断新增、修改是否成功
        if(is){
            p=mapper.updateRole(roleInfo.getRoleId(),roleInfo.getRoleName(),id);//修改
            /*int t=mapper.delRoleDept(roleInfo.getRoleId());
            if(t<0){
                new RuntimeException("修改数据失败");
            }*/
        }else{
            //新增角色
            p=mapper.addRole(roleInfo.getRoleId(),roleInfo.getRoleName(),roleInfo.getRoleCreate(),id);
        }
        //批量新增角色和部门中间表，可以不新增
        int k=0;
        if(list.isEmpty()){
            k=1;
        }else{
            k=mapper.addRoleDept(list);
        }
        if(p>0 && k>0){
            return 1;
        }
        new RuntimeException("新增失败");
        return 0;
    }

    /**
     * 级联删除角色
     * @param choose
     * @return
     */
    public int delRole(JSONArray choose){
        return mapper.delRole(choose);
    }
}
