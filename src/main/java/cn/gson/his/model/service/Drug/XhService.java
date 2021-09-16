package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.*;
import cn.gson.his.model.mappers.Drug.CangkMapper;
import cn.gson.his.model.mappers.Drug.XhMapper;
import cn.gson.his.model.pojos.Drug.*;
import cn.gson.his.model.pojos.Power.Employee;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
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

    @Autowired
    CangkMapper cangkMapper;

    @Autowired
    ChukDao chukDao;

    @Autowired
    ChukjlDao chukjlDao;

    @Autowired
    CankxqDao cankxqDao;

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

    public Map<String,Object> shxh(Integer id){
        Map<String,Object> map = new HashMap<>();
        //销毁详情数据
        List<Destroyxq> xhxqcx = xhMapper.xhxqcx(id, "");
        //可销毁
        List<Destroyxq> destroyxqList=new ArrayList<>();
        for (Destroyxq destroyxq : xhxqcx) {
            LibraryxqEntity ckxqcxid = cangkMapper.ckxqcxid(destroyxq.getLibrary().getLibraryId(), destroyxq.getProductId(), destroyxq.getProductFl(), destroyxq.getPh());
            if(destroyxq.getSl()<=ckxqcxid.getKcs()){
                destroyxqList.add(destroyxq);
            }else {
                if(ckxqcxid.getKcs()>0){
                    destroyxq.setSl(ckxqcxid.getKcs());
                    destroyxqList.add(destroyxq);
                }
            }
        }
        System.out.println("emm");
        for (Destroyxq destroyxq : destroyxqList) {
            System.out.println(destroyxqList.toString());
        }
        map.put("xhxq",xhxqcx);
        map.put("kxhxq",destroyxqList);
        return map;
    }

    public void bh(Destroy destroy){
        destroy.setDestroyZt(2);
        xhDao.save(destroy);
    }

    public void xzxhrck(Destroy destroy, Employee shr, List<Destroyxq> destroyxqList){
        Timestamp d = new Timestamp(System.currentTimeMillis());
        List<Integer> list=new ArrayList<>();
        int a=0;
        //获取调拨详情里所有的仓库编号
        for (Destroyxq destroyxq : destroyxqList) {
            for (Integer integer : list) {
                if(destroyxq.getLibrary().getLibraryId()==integer){
                    a=1;
                    break;
                }
            }
            if(a==0){
                list.add(destroyxq.getLibrary().getLibraryId());
            }
            a=0;
        }
        //新增出库记录
        for (Integer integer : list) {
            LibraryInfoEntity libraryInfoEntity=new LibraryInfoEntity();
            libraryInfoEntity.setLibraryId(integer);
            ChuEntity chuEntity=new ChuEntity(d,libraryInfoEntity,shr,2,String.valueOf(destroy.getDestroyId()));
            chukDao.save(chuEntity);
            for (Destroyxq destroyxq : destroyxqList) {
                if(integer==destroyxq.getLibrary().getLibraryId()){
                    ChujlEntity chujlEntity = new ChujlEntity(destroyxq.getProductId(),destroyxq.getProductName(),destroyxq.getProductFl(),destroyxq.getSl(),destroyxq.getPh(),chuEntity.getChuId(),destroyxq.getGe(),destroyxq.getGys(),destroyxq.getScdate(),destroyxq.getGqdate(),destroyxq.getPrice(),destroyxq.getKszt(),destroyxq.getGesl(),destroyxq.getShdw());
                    chukjlDao.save(chujlEntity);
                    LibraryxqEntity ckxqcxid = cangkMapper.ckxqcxid(destroyxq.getLibrary().getLibraryId(), destroyxq.getProductId(), destroyxq.getProductFl(), destroyxq.getPh());
                    ckxqcxid.setKcs(ckxqcxid.getKcs()-destroyxq.getSl());
                    cankxqDao.save(ckxqcxid);
                }
            }
        }

        destroy.setDestroyZt(1);
        xhDao.save(destroy);
    }
}
