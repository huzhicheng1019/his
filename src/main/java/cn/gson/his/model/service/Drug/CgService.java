package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.CgDao;
import cn.gson.his.model.dao.Drug.CgxqDao;
import cn.gson.his.model.mappers.Drug.CgMapper;
import cn.gson.his.model.mappers.Drug.CgjhMapper;
import cn.gson.his.model.pojos.Drug.*;
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
public class CgService {
    @Autowired
    CgMapper cgMapper;

    @Autowired
    CgjhMapper cgjhMapper;

    @Autowired
    CgDao cgDao;

    @Autowired
    CgxqDao cgxqDao;

    public Map<String,Object> cgcx(int pageNo, int size,String nr){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("cg",cgMapper.cgcx(nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> cgxqselect(int pageNo, int size,String id, String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",cgMapper.cgxqcx(id,nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> xzcgxx(String id, String nr){
        Map<String,Object> map = new HashMap<>();
        map.put("cg",cgMapper.cgcxid(id).get(0));
        map.put("cgxq",cgMapper.cgxqcx(id, nr));
        return map;
    }

    public Map<String,Object> empcx(){
        Map<String,Object> map = new HashMap<>();
        map.put("emp",cgMapper.empcx());
        return map;
    }

    public void xzxgcg(OrdersEntity ordersEntity, List<OrderxqEntity> orderxqEntityList, List<OrderxqEntity> delxq){
        for (OrderxqEntity orderxqEntity : delxq) {
            cgxqDao.deleteById(orderxqEntity.getOrderxqId());

        }
        cgDao.save(ordersEntity);
        for (OrderxqEntity orderxqEntity : orderxqEntityList) {
            orderxqEntity.setOrderId(ordersEntity.getOrderId());
            cgxqDao.save(orderxqEntity);
        }
    }

    public String scxgpd(String id){
        List<StoEntity> stocx = cgMapper.stocx(id);
        if(stocx.size()>0){
            return "该采购订单已入库,不可删除或更改";
        }else {
            return "ok";
        }
    }

    public String cgdel(String id){
        List<StoEntity> stocx = cgMapper.stocx(id);
        if(stocx.size()>0){
            return "该采购订单已入库,不可删除或更改";
        }else {
            List<OrderxqEntity> cgxqcx = cgMapper.cgxqcx(id, "");
            for (OrderxqEntity orderxqEntity : cgxqcx) {
                cgxqDao.deleteById(orderxqEntity.getOrderxqId());

            }
            cgDao.deleteById(id);
            return "ok";
        }
    }
}
