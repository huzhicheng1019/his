package cn.gson.his.model.service.Power;

import cn.gson.his.model.dao.Power.EmployeeDao;
import cn.gson.his.model.dao.Power.RoleDao;
import cn.gson.his.model.dao.Power.UserDao;
import cn.gson.his.model.mappers.Power.EmployeeMapper;
import cn.gson.his.model.mappers.Power.RoleMapper;
import cn.gson.his.model.pojos.Power.*;
import cn.gson.his.model.pojos.Power.vo.ScreeningVo;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeService {
    @Autowired
    EmployeeMapper empMapper;

    @Autowired
    EmployeeDao dao;

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserService service;

    //查询住院部的医生
    public List<Employee> selDoctor(Integer depaId){
        return empMapper.selDoctor(depaId);
    }
    //查询住院部某科室的护士
    public List<Employee> selNurse(Integer depaId){
        return empMapper.selNurse(depaId);
    };


    /**
     * 分页查询所有
     * @return
     */
    public List<Employee> allEmp( Timestamp start,Timestamp end,Integer state,List<Integer> screening,String fuzzy){
        System.out.println("是否在职"+state);
        List<Employee> list = empMapper.allEmp(start,end,state,screening,fuzzy);
        return list;
    }

    /**
     * 一对一新增、修改员工、用户
     * @param emp
     * @return
     */
    public int addEmp(Employee emp) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if(emp.getDepartmentByEmpDepar().getDepaId()==null){
            emp.setDepartmentByEmpDepar(null);
        }
        System.out.println("员工id"+emp.getEmpId());
        if(emp.getEmpId()==null){
            String encryptedPwd = MD5.getEncryptedPwd("123456");
            emp.getUseres().setUserPass(encryptedPwd);
        }
        emp.getUseres().setEmployeeByUserEmp(emp);
        Employee s = dao.save(emp);
        UserInfo u = userDao.save(emp.getUseres());
        return s==null || u==null ? 0:1;
    }

    /**
     * 批量离职、重置密码
     * @param choose
     * @return
     */
    public int quitEmp(JSONArray choose) {
        int p=empMapper.quitEmp(choose);
        return p;
    }

    /**
     * 根据用户id查询角色id
     * @param userId
     * @return
     */
    public List<Integer> allEmpRole(Integer userId) {
        return empMapper.allEmpRole(userId);
    }

    /**
     * 授权角色、新增中间表
     * @param userId
     * @param funs
     */
    public void addRolePerm(Integer userId, List<Integer> funs) {
        UserInfo userInfo = userDao.findById(userId).get();
        List<RoleInfo> allById =
                (List<RoleInfo>)roleDao.findAllById(funs);

        List<RoleInfo> functions = userInfo.getRoleinfos();
        if(functions == null){
            functions = new ArrayList<>();
        }
        functions.clear();//把原来的全部清空
        functions.addAll(allById);
        userInfo.setRoleinfos(functions);//触发中间表新增
    }

    /**
     * 查询角色
     * @return
     */
    public List<RoleInfo> allRole() {
        List<RoleInfo> roleInfos = empMapper.allRole();
        for (RoleInfo r : roleInfos) {
            r.setRoleInfoList(childrenRole(r.getRoleId()));
        }
        return roleInfos;
    }

    public List<RoleInfo> childrenRole(Integer roleId){
        List<RoleInfo> childrenRoles = empMapper.childrenRole(roleId);
        for (RoleInfo cFun : childrenRoles) {
            cFun.setRoleInfoList(childrenRole(cFun.getRoleId()));
        }
        return childrenRoles;
    };

    public List<Perm> homeMenu(Integer userId){
        return empMapper.homeMenu(userId);
    }

    public List<ScreeningVo> allTitle() {
        return empMapper.allTitle();
    }

    public List<ScreeningVo> allDept() {
        System.out.println("部门"+empMapper.allDept());
        return empMapper.allDept();
    }

    public List<ScreeningVo> allDepa() {
        return empMapper.allDepa();
    }

    public ElMessage xiumm(String pass, Integer userId) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ElMessage elm=new ElMessage();
        String encryptedPwd = MD5.getEncryptedPwd(pass);
        int p = empMapper.xiumm(encryptedPwd,userId);
        if(p>0){
            elm.setMessage("修改密码成功！");
            elm.setType("success");
        }
        return elm;
    }
}
