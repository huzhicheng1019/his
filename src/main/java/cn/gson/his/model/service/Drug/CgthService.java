package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.CgthDao;
import cn.gson.his.model.dao.Drug.CgthxqDao;
import cn.gson.his.model.mappers.Drug.CgthMapper;
import cn.gson.his.model.pojos.Drug.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CgthService {
    @Autowired
    CgthMapper cgthMapper;

    @Autowired
    CgthDao cgthDao;

    @Autowired
    CgthxqDao cgthxqDao;

    public Map<String,Object> cgthcx(int pageNo, int size, String nr, Date qssj, Date jssj){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("cg",cgthMapper.cgthglcx(nr,qssj,jssj));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> cgthxqselect(int pageNo, int size,String id, String nr) {
        System.out.println(id);
        System.out.println(nr);
        Map<String, Object> map = new HashMap<>();
        //分页查询
        Page<Object> page = PageHelper.startPage(pageNo, size);
        map.put("rows", cgthMapper.cgthxqcx(id, nr));
        map.put("total", page.getTotal());
        return map;
    }

    public Map<String,Object> cgrkxqcx(String id) {
        System.out.println(id);
        Map<String, Object> map = new HashMap<>();
        map.put("rows", cgthMapper.stojllyid(id));
        return map;
    }

    public Map<String,Object> cgthxx(String id, String nr){
        Map<String,Object> map = new HashMap<>();
        map.put("cgth",cgthMapper.cgthid(id).get(0));
        map.put("cgthxq",cgthMapper.cgthxqcx(id, nr));
        return map;
    }

    public void xzxgcgth(OrderthEntity orderthEntity, List<OrderthxqEntity> orderxqEntityList, List<OrderthxqEntity> delxq){
        for (OrderthxqEntity orderthxqEntity : delxq) {
            cgthxqDao.deleteById(orderthxqEntity.getOrderthxqId());
        }
        cgthDao.save(orderthEntity);
        for (OrderthxqEntity orderthxqEntity : orderxqEntityList) {
            orderthxqEntity.setOrderthId(orderthEntity.getOrderthId());
            cgthxqDao.save(orderthxqEntity);
        }
    }

    public String scxgpd(String id){
        List<ChuEntity> chucx = cgthMapper.chucx(id);
        if(chucx.size()>0){
            return "该退货单已出库,不可删除或更改";
        }else {
            return "ok";
        }
    }

    public String cgdel(String id){
        List<ChuEntity> chucx = cgthMapper.chucx(id);
        if(chucx.size()>0){
            return "该退货单已出库,不可删除或更改";
        }else {
            List<OrderthxqEntity> cgthxqcx = cgthMapper.cgthxqcx(id, "");
            for (OrderthxqEntity orderthxqEntity : cgthxqcx) {
                cgthxqDao.deleteById(orderthxqEntity.getOrderthxqId());
            }
            cgthDao.deleteById(id);
            return "ok";
        }
    }
}
