package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.XhDao;
import cn.gson.his.model.dao.Drug.XhxqDao;
import cn.gson.his.model.mappers.Drug.XhMapper;
import cn.gson.his.model.pojos.Drug.Allotxq;
import cn.gson.his.model.pojos.Drug.Destroy;
import cn.gson.his.model.pojos.Drug.Destroyxq;
import cn.gson.his.model.pojos.Drug.StoEntity;
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
public class XhService {
    @Autowired
    XhMapper xhMapper;

    @Autowired
    XhDao xhDao;

    @Autowired
    XhxqDao xhxqDao;

    public Map<String,Object> xhselect(int pageNo, int size, String nr){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",xhMapper.xhcx(nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> xhxqselect(int pageNo, int size,Integer id, String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",xhMapper.xhxqcx(id, nr));
        map.put("total",page.getTotal());
        return map;
    }

    public void xzxgxh(Destroy destroy, List<Destroyxq> destroyxqList, List<Destroyxq> delxq){
        System.out.println("one");
        for (Destroyxq destroyxq : delxq) {
            xhxqDao.deleteById(destroyxq.getDestroyxqId());
        }
        System.out.println("two");
        xhDao.save(destroy);
        for (Destroyxq destroyxq : destroyxqList) {
            destroyxq.setDestroyId(destroy.getDestroyId());
            xhxqDao.save(destroyxq);
        }
        System.out.println("three");
    }

    public Map<String,Object> xhcxid(Integer id){
        Map<String,Object> map = new HashMap<>();
        map.put("xh",xhMapper.xhcxid(id).get(0));
        map.put("xhxq",xhMapper.xhxqcx(id, ""));
        return map;
    }

    public void xhdel(Integer id){
        List<Destroyxq> xhxqcx = xhMapper.xhxqcx(id, "");
        for (Destroyxq destroyxq : xhxqcx) {
            xhxqDao.deleteById(destroyxq.getDestroyxqId());
        }
        xhDao.deleteById(id);
    }
}
