package cn.gson.his.model.service.Power;

import cn.gson.his.model.dao.Power.ScheduDao;
import cn.gson.his.model.mappers.Power.ScheduMapper;
import cn.gson.his.model.pojos.Power.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class ScheduService {

    @Autowired
    ScheduDao dao;

    @Autowired
    ScheduMapper mapper;

    /**
     * 根据部门查询科室
     * @param name
     * @return
     */
    /*public List<Department> deptIdByDepaByTit(String name){
        Integer id=mapper.allDeptId(name);
        List<Department> depas= mapper.deptIdDepa(id);
        return depas;
    }

    *//**
     * 根据部门和科室查询员工
     * @param name
     * @param depa
     * @return
     *//*
    public List<Employee> depaIdByEmp(String name,Integer depa){
        Integer id=mapper.allDeptId(name);
        List<Employee> emp=mapper.depaIdByEmp(id,depa);
        return emp;
    }

    *//**
     * 查询所有班次
     * @return
     *//*
    public List<Shift> allShift(){
        return mapper.allShift();
    }

    *//**
     * 新增排班
     * @param list
     * @return
     *//*
    public int addSchedu(List<Schedu> list){
        return mapper.addSchedu(list);
    }

    *//**
     * 查询排班
     * @param pageNo
     * @param size
     * @param dept
     * @return
     *//*
    public Map<String, Object> allSche(Integer pageNo, Integer size, String dept) {
        Page<Object> p = PageHelper.startPage(pageNo,size);
        List<Map<String,Object>> list = mapper.allSche(dept);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",p.getTotal());
        return map;
    }
*/

    /**
     * 根据班次类型查询班次
     * @param typeId
     * @return
     */
    public List<Shift> allShiftById(Integer typeId) {
        return mapper.allShiftById(typeId);
    }

    /*public List<Schedu> allScheEmp(){
        return mapper.allScheEmp();
    }*/

    public List<Integer> allScheByempId(Integer deptId,Integer deparId, Integer scheId, Integer shiId) {
        return mapper.allScheByempId(deptId,deparId,scheId,shiId);
    }

    public int  addScheEmp(List<Integer> emp,Integer deparId,Integer shiId,Integer scheId) {
        int y=-1;
        int p=mapper.delScheEmp(deparId,shiId,scheId);
        if(emp.isEmpty()==false){
        List<Integer> funs=mapper.allEmpById(emp);
            List<ScheEmp> list=new ArrayList<>();
            for (int i=0;i<funs.size();i++){
                ScheEmp scheEmp1=add(funs.get(i),shiId,scheId);
                list.add(scheEmp1);
            }
            y=mapper.addScheEmp(list);
        }
        //System.out.println("删除有效行"+p);
        y=p>-1 ? 1:0;
        return y>0 ? 1:0;
    }

    public ScheEmp add(Integer empId,Integer shiId,Integer scheId){
        Employee employee=new Employee();
        employee.setEmpId(empId);
        Shift shift=new Shift();
        shift.setShiId(shiId);
        Schedu schedu=new Schedu();
        schedu.setScheId(scheId);
        ScheEmp scheEmp1=new ScheEmp();
        scheEmp1.setEmp(employee);
        scheEmp1.setShift(shift);
        scheEmp1.setScheduByScheId(schedu);
        return scheEmp1;
    }

    public List<Schedu> allSchedu(Integer date){
        List<Schedu> list=mapper.allScheEmp(date);
        return list;
    }

    public int addSchedu(Integer date) throws ParseException {
        List<Schedu> list = getLastTimeInterval(date);
        return mapper.addSchedu(list);
    }

    public List<Schedu> allORaddSchedu(Integer date) throws ParseException {
        List<Schedu> list=allSchedu(date);
        if(list.isEmpty()){
            int p=addSchedu(date);
            if(p>0){
                list=allSchedu(date);
            }
        }
        return list;
    }

    /**
     * 根据当前日期获得上周的日期区间（上周周一和周日日期）
     * @param value
     * @return
     * @throws ParseException
     */
    public List<Schedu> getLastTimeInterval(Integer value) throws ParseException {
        Calendar cal=Calendar.getInstance();
        int week=cal.get(Calendar.DAY_OF_WEEK)-1;
        if(week==0){
            value=value-7;
        }
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        int offset1 = 1 - dayOfWeek;
        int offset2 = 7 - dayOfWeek;
        calendar1.add(Calendar.DATE, offset1 + value);
        calendar2.add(Calendar.DATE, offset2 + value);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // System.out.println(sdf.format(calendar1.getTime()));// last Monday
        String lastBeginDate = sdf.format(calendar1.getTime());
        // System.out.println(sdf.format(calendar2.getTime()));// last Sunday
        String lastEndDate = sdf.format(calendar2.getTime());
        Date dBegin = sdf.parse(lastBeginDate);
        Date dEnd = sdf.parse(lastEndDate);
        return findDates(dBegin,dEnd);
    }

    /**
     * 获取一周开始到结束的list集合
     * @param dBegin
     * @param dEnd
     * @return
     */
    public List<Schedu> findDates(Date dBegin, Date dEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Schedu> lDate = new ArrayList();
        lDate.add(new Schedu(sdf.format(dBegin),dateToWeek(sdf.format(dBegin))));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime()))
        {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(new Schedu(sdf.format(calBegin.getTime()),dateToWeek(sdf.format(calBegin.getTime()))));
        }
        return lDate;
    }

    /**
     * 根据日期计算星期几
     * @param datetime
     * @return
     */
    public String dateToWeek(String datetime) {

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        Date date;
        try {
            date = f.parse(datetime);
            cal.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //一周的第几天
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public List<Dept> getdepts() {
        return mapper.getdepts();
    }

    public List<Department> getdepar(Integer deptId) {
        return mapper.getdepar(deptId);
    }

}
