package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.PremiumDao;
import cn.gson.his.model.dao.Drug.PremiumsDao;
import cn.gson.his.model.mappers.Drug.TfMapper;
import cn.gson.his.model.pojos.Drug.Premium;
import cn.gson.his.model.pojos.Drug.Premiums;
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
@Transactional
public class TfService {
    @Autowired
    PremiumDao premiumDao;
    @Autowired
    PremiumsDao premiumsDao;
    @Autowired
    TfMapper tfMapper;

    public void xztf(Premium premium, List<Premiums> premiumsList){
        Timestamp d = new Timestamp(System.currentTimeMillis());
        premium.setPremiumDate(d);
        premiumDao.save(premium);
        for (Premiums premiums : premiumsList) {
            premiums.setPremiumId(premium.getPremiumId());
            premiumsDao.save(premiums);
        }
    }

    public Map<String,Object> tfsqselect(int pageNo, int size, String nr){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",tfMapper.tfsqcx(nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> tfsqxqselect(int pageNo, int size,String id, String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",tfMapper.tfsqxqcx(id, nr));
        map.put("total",page.getTotal());
        return map;
    }
}
