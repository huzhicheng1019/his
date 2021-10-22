package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.*;
import cn.gson.his.model.mappers.Drug.CangkMapper;
import cn.gson.his.model.mappers.Drug.PdMapper;
import cn.gson.his.model.pojos.Drug.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

@Service
@Transactional
public class PdService {
    @Autowired
    CangkMapper cangkMapper;

    @Autowired
    PdDao pdDao;

    @Autowired
    PdxqDao pdxqDao;

    @Autowired
    PdMapper pdMapper;

    @Autowired
    XhDao xhDao;

    @Autowired
    XhxqDao xhxqDao;

    @Autowired
    CankxqDao cankxqDao;

    @Autowired
    AuditInfoDao auditInfoDao;

    public Map<String,Object> ckpdcx(Integer id, Integer lx){
        System.out.println(id);
        Map<String,Object> map = new HashMap<>();
        List<LibraryxqEntity> ckxqcx = new ArrayList<>();
        if(lx==0){
            ckxqcx=cangkMapper.ckxqcx(id, "");
        }else if(lx==1){
            ckxqcx=cangkMapper.ckhscx(id);
        }else if(lx==2){
            ckxqcx=cangkMapper.ckgqcx(id);
        }else{
            ckxqcx=cangkMapper.cklqcx(id);
        }
        map.put("rows",ckxqcx);
        return map;
    }

    public void xzPd(ChecksEntity checksEntity, List<Checkxq> checkxqList){
        System.out.println("one");
        pdDao.save(checksEntity);
        for (Checkxq checkxq : checkxqList) {
            checkxq.setCheckId(checksEntity.getCheckId());
            pdxqDao.save(checkxq);
        }
        System.out.println("three");
    }

    public Map<String,Object> pdselect(int pageNo, int size, String nr, Date qssj, Date jssj){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",pdMapper.pdcx(nr,qssj,jssj));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> pdxqselect(int pageNo, int size,String id, String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",pdMapper.pdxqcx(id, nr));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> shpdxqcx(String id){
        System.out.println(id);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",pdMapper.pdxqcx(id, ""));
        return map;
    }

    public void bh(ChecksEntity checksEntity,AuditInfo auditInfo){
        checksEntity.setZt(2);
        auditInfoDao.save(auditInfo);
        pdDao.save(checksEntity);
    }

    public void pdsh(ChecksEntity checksEntity,List<Checkxq> checkxqList,Destroy destroy,List<Destroyxq> destroyxq,AuditInfo auditInfo){
        System.out.println(checksEntity.getPdlx());
        System.out.println(destroy.getDestroyId());
        checksEntity.setZt(1);
        pdDao.save(checksEntity);
        if(checksEntity.getPdlx()!=0){
            if(!destroy.getDestroyId().equals("")){
                Timestamp d = new Timestamp(System.currentTimeMillis());
                destroy.setSqdate(d);
                xhDao.save(destroy);
                for (Destroyxq destroyxq1 : destroyxq) {
                    destroyxq1.setDestroyId(destroy.getDestroyId());
                    xhxqDao.save(destroyxq1);
                }
            }
        }else{
            for (Checkxq checkxq : checkxqList) {
                LibraryxqEntity ckxqcxid = cangkMapper.ckxqcxid(checksEntity.getLibrary().getLibraryId(), checkxq.getProductId(), checkxq.getProductFl(), checkxq.getPh());
                ckxqcxid.setKcs(checkxq.getSjkc());
                cankxqDao.save(ckxqcxid);
            }
        }
        auditInfoDao.save(auditInfo);
    }
}
