package cn.gson.his.model.service.Drug;

import cn.gson.his.model.mappers.Drug.TyMapper;
import cn.gson.his.model.pojos.Drug.Pillsxq;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TyService {
    @Autowired
    TyMapper tyMapper;

    public Map<String,Object> tyselect(int pageNo, int size, String nr){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",tyMapper.tycx(nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> tyxqselect(int pageNo, int size,String id, String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",tyMapper.tyxqcx(id,nr));
        map.put("total",page.getTotal());
        return map;
    }


}
