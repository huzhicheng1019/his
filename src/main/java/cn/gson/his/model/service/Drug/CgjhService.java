package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.CgjhDao;
import cn.gson.his.model.dao.Drug.CgjhxqDao;
import cn.gson.his.model.mappers.Drug.CgjhMapper;
import cn.gson.his.model.pojos.Drug.OrdersEntity;
import cn.gson.his.model.pojos.Drug.PlanInfoEntity;
import cn.gson.his.model.pojos.Drug.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CgjhService {
    @Autowired
    CgjhDao cgjhDao;

    @Autowired
    CgjhxqDao cgjhxqDao;

    @Autowired
    CgjhMapper cgjhMapper;

    public Map<String,Object> cgjhcx(String nr){
        Map<String,Object> map = new HashMap<>();
        map.put("cgjh",cgjhMapper.cgjhcx(nr));
        return map;
    }

    public Map<String,Object> cgjhxqcx(Integer id, String nr){
        Map<String,Object> map = new HashMap<>();
        map.put("cgjhxq",cgjhMapper.cgjhxqcx(id, nr));
        return map;
    }

    public Map<String,Object> xzcgjhxx(Integer id, String nr){
        Map<String,Object> map = new HashMap<>();
        map.put("cgjh",cgjhMapper.cgjhcxid(id).get(0));
        map.put("cgjhxq",cgjhMapper.cgjhxqcx(id, nr));
        return map;
    }

    public void xzxgcgjh(PlanInfoEntity planInfoEntity,List<ProductEntity> productEntityList,List<ProductEntity> delxq){
        for (ProductEntity productEntity : delxq) {
            cgjhxqDao.deleteById(productEntity.getProductId());
        }
        cgjhDao.save(planInfoEntity);
        for (ProductEntity productEntity : productEntityList) {
            productEntity.setPlanId(planInfoEntity.getPlanId());
            cgjhxqDao.save(productEntity);
        }
    }

    public String scxgpd(Integer id){
        List<OrdersEntity> cgcx = cgjhMapper.cgcx(id);
        if(cgcx.size()>0){
            return "该计划已被应用,不可删除或更改";
        }else {
            return "ok";
        }
    }

}
