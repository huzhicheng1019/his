package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.AuditInfoDao;
import cn.gson.his.model.dao.Drug.CgjhDao;
import cn.gson.his.model.dao.Drug.CgjhxqDao;
import cn.gson.his.model.mappers.Drug.CgMapper;
import cn.gson.his.model.mappers.Drug.CgjhMapper;
import cn.gson.his.model.pojos.Drug.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CgjhService {
    @Autowired
    CgjhDao cgjhDao;

    @Autowired
    CgjhxqDao cgjhxqDao;

    @Autowired
    CgjhMapper cgjhMapper;

    @Autowired
    CgMapper cgMapper;

    @Autowired
    AuditInfoDao auditInfoDao;

    public Map<String,Object> cgjhcx(Integer pageNo, Integer size,String nr, Date qssj, Date jssj,Date cgqssj, Date cgjssj){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("cgjh",cgjhMapper.cgjhcx(nr,qssj,jssj,cgqssj,cgjssj));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> cgjhxqcx(String id, String nr){
        Map<String,Object> map = new HashMap<>();
        map.put("cgjhxq",cgjhMapper.cgjhxqcx(id, nr));
        return map;
    }

    public Map<String,Object> xzcgjhxx(String id, String nr){
        Map<String,Object> map = new HashMap<>();
        map.put("cgjh",cgjhMapper.cgjhcxid(id).get(0));
        map.put("cgjhxq",cgjhMapper.cgjhxqcx(id, nr));
        return map;
    }

    public void xzxgcgjh(PlanInfoEntity planInfoEntity,List<ProductEntity> productEntityList,List<ProductEntity> delxq){
        for (ProductEntity productEntity : delxq) {
            cgjhxqDao.deleteById(productEntity.getPlanxqId());
        }
        cgjhDao.save(planInfoEntity);
        for (ProductEntity productEntity : productEntityList) {
            productEntity.setPlanId(planInfoEntity.getPlanId());
            cgjhxqDao.save(productEntity);
        }
    }

    public String scxgpd(String id){
        List<OrdersEntity> cgcx = cgjhMapper.cgcx(id);
        if(cgcx.size()>0){
            return "该计划已被应用,不可删除或更改";
        }else {
            return "ok";
        }
    }

    public String cgjhdel(String id){
        List<OrdersEntity> cgcx = cgjhMapper.cgcx(id);
        if(cgcx.size()>0){
            return "该计划已被应用,不可删除或更改";
        }else {
            List<ProductEntity> cgjhxqcx = cgjhMapper.cgjhxqcx(id, "");
            for (ProductEntity productEntity : cgjhxqcx) {
                cgjhxqDao.deleteById(productEntity.getPlanxqId());
            }
            cgjhDao.deleteById(id);
            return "ok";
        }
    }

    public void sh(PlanInfoEntity planInfoEntity, AuditInfo auditInfo){
        cgjhDao.save(planInfoEntity);
        auditInfoDao.save(auditInfo);
    }

    public void tjsh(PlanInfoEntity planInfoEntity){
        cgjhDao.save(planInfoEntity);
    }


    public Map<String,Object> cgjhdd(String nr){
        Map<String,Object> map = new HashMap<>();
        map.put("cgjh",cgjhMapper.cgjhdd(nr));
        return map;
    }

    public Map<String,Object> cgjhddxq(String id, Integer gid){
        Map<String,Object> map = new HashMap<>();
        List<ProductEntity> cgjhddxq = cgjhMapper.cgjhddxq(id, gid);
        List<OrdersEntity> xzcgddcx = cgMapper.xzcgddcx(id, gid);

        for (OrdersEntity ordersEntity : xzcgddcx) {
            List<OrderxqEntity> cgxqcx = cgMapper.cgxqcx(ordersEntity.getOrderId(), "");
            for (ProductEntity productEntity : cgjhddxq) {
                for (OrderxqEntity orderxqEntity : cgxqcx) {
                    if(productEntity.getProductId().equals(orderxqEntity.getProductId()) && productEntity.getProductFl().equals(orderxqEntity.getProductFl())){
                        productEntity.setSl(productEntity.getSl()- orderxqEntity.getSl());
                    }
                }
            }
        }

        for(int i=0;i<cgjhddxq.size();i++){
            if(cgjhddxq.get(i).getSl()<=0){
                cgjhddxq.remove(i);
                i--;
            }
        }
        map.put("cgjhxq",cgjhddxq);
        return map;
    }
}
