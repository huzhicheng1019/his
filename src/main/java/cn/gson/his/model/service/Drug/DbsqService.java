package cn.gson.his.model.service.Drug;

import antlr.StringUtils;
import cn.gson.his.model.dao.Drug.*;
import cn.gson.his.model.mappers.Drug.CangkMapper;
import cn.gson.his.model.mappers.Drug.ConMapper;
import cn.gson.his.model.mappers.Drug.DbsqMapper;
import cn.gson.his.model.mappers.Drug.YpMapper;
import cn.gson.his.model.pojos.Drug.*;
import cn.gson.his.model.pojos.Power.Employee;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

@Service
@Transactional
public class DbsqService {
    @Autowired
    DbsqMapper dbsqMapper;
    @Autowired
    CangkMapper cangkMapper;
    @Autowired
    DbDao dbDao;
    @Autowired
    DbxqDao dbxqDao;

    @Autowired
    ChukDao chukDao;

    @Autowired
    ChukjlDao chukjlDao;

    @Autowired
    RkDao rkDao;

    @Autowired
    RkxqDao rkxqDao;

    @Autowired
    CankxqDao cankxqDao;

    @Autowired
    YpMapper ypMapper;

    @Autowired
    ConMapper conMapper;

    @Autowired
    AuditInfoDao auditInfoDao;

    public Map<String,Object> dbselect(int pageNo, int size, String nr, Date qssj, Date jssj, Date dbqssj, Date dbjssj){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",dbsqMapper.dbcx(nr,qssj,jssj,dbqssj,dbjssj));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String,Object> dbxqselect(String id, String nr){
        System.out.println(id);
        System.out.println(nr);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",dbsqMapper.dbxqcx(id, nr));
        return map;
    }

    public Map<String,Object> dbckxqcx(Integer id, String nr,Integer ckid,Integer ckdj){
        System.out.println(id);
        System.out.println(nr);
        Map<String,Object> map = new HashMap<>();
        List<LibraryxqEntity> libraryxqEntityList=new ArrayList<>();
        List<LibraryxqEntity> dbckxqcx = cangkMapper.dbckxqcx(id, nr, ckid,ckdj);
        for (LibraryxqEntity libraryxqEntity : dbckxqcx) {
            if(libraryxqEntity.getKcs()>0){
                libraryxqEntityList.add(libraryxqEntity);
            }
        }
        map.put("rows",libraryxqEntityList);
        return map;
    }

    public void xzxgdb(Allot allot, List<Allotxq> allotxqList, List<Allotxq> delxq){
        for (Allotxq allotxq : delxq) {
            dbxqDao.deleteById(allotxq.getAllotxqId());
        }
        dbDao.save(allot);
        for (Allotxq allotxq : allotxqList) {
            allotxq.setAllotId(allot.getAllotId());
            dbxqDao.save(allotxq);
        }
    }

    public Map<String,Object> dbcxid(String id){
        Map<String,Object> map = new HashMap<>();
        map.put("db",dbsqMapper.dbxx(id).get(0));
        map.put("dbxq",dbsqMapper.dbxqcx(id, ""));
        return map;
    }

    public String scxgpd(String id){
        List<StoEntity> stocx = dbsqMapper.stocx(id);
        if(stocx.size()>0){
            return "该调拨申请单已入库,不可删除或更改";
        }else {
            return "ok";
        }
    }

    public String dbdel(String id){
        List<StoEntity> stocx = dbsqMapper.stocx(id);
        if(stocx.size()>0){
            return "该调拨申请单已入库,不可删除或更改";
        }else {
            List<Allotxq> dbxqcx = dbsqMapper.dbxqcx(id, "");
            for (Allotxq allotxq : dbxqcx) {
                dbxqDao.deleteById(allotxq.getAllotxqId());
            }
            dbDao.deleteById(id);
            return "ok";
        }
    }

    public Map<String,Object> shdb(String id){
        Map<String,Object> map = new HashMap<>();
        //调拨详情数据
        List<Allotxq> dbxqcx = dbsqMapper.dbxqcx(id, "");
        //可调拨
        List<Allotxq> allotxqList=new ArrayList<>();
        for (Allotxq allotxq : dbxqcx) {
            LibraryxqEntity ckxqcxid = cangkMapper.ckxqcxid(allotxq.getLibraryto().getLibraryId(), allotxq.getProductId(), allotxq.getProductFl(), allotxq.getPh());
            if(allotxq.getSl()<=ckxqcxid.getKcs()){
                allotxqList.add(allotxq);
            }else {
                if(ckxqcxid.getKcs()>0){
                    allotxq.setSl(ckxqcxid.getKcs());
                    allotxqList.add(allotxq);
                }
            }
        }
        System.out.println("emm");
        for (Allotxq allotxq : allotxqList) {
            System.out.println(allotxqList.toString());
        }
        map.put("dbxq",dbxqcx);
        map.put("kdbxq",allotxqList);
        return map;
    }

    public void xzdbrck(Allot allot, Employee shr, List<Allotxq> allotxqList,AuditInfo auditInfo){
        Timestamp d = new Timestamp(System.currentTimeMillis());
        List<Integer> list=new ArrayList<>();
        int a=0;
        //获取调拨详情里所有的仓库编号
        for (Allotxq allotxq : allotxqList) {
            for (Integer integer : list) {
                if(allotxq.getLibraryto().getLibraryId()==integer){
                    a=1;
                    break;
                }
            }
            if(a==0){
                list.add(allotxq.getLibraryto().getLibraryId());
            }
            a=0;
        }
        //新增出库记录
        for (Integer integer : list) {
            LibraryInfoEntity libraryInfoEntity=new LibraryInfoEntity();
            libraryInfoEntity.setLibraryId(integer);
            ChuEntity chuEntity=new ChuEntity(d,libraryInfoEntity,shr,2,String.valueOf(allot.getAllotId()));
            chukDao.save(chuEntity);
            for (Allotxq allotxq : allotxqList) {
                if(integer==allotxq.getLibraryto().getLibraryId()){
                    ChujlEntity chujlEntity = new ChujlEntity(allotxq.getProductId(),allotxq.getProductName(),allotxq.getProductFl(),allotxq.getSl(),allotxq.getPh(),chuEntity.getChuId(),allotxq.getGe(),allotxq.getGys(),allotxq.getScdate(),allotxq.getGqdate(),allotxq.getPrice(),allotxq.getKszt(),allotxq.getGesl(),allotxq.getShdw());
                    chukjlDao.save(chujlEntity);
                    LibraryxqEntity ckxqcxid = cangkMapper.ckxqcxid(allotxq.getLibraryto().getLibraryId(), allotxq.getProductId(), allotxq.getProductFl(), allotxq.getPh());
                    ckxqcxid.setKcs(ckxqcxid.getKcs()-allotxq.getSl());
                    cankxqDao.save(ckxqcxid);
                }
            }
        }

        StoEntity stoEntity=new StoEntity(d,allot.getLibrary(),1,shr,String.valueOf(allot.getAllotId()));
        rkDao.save(stoEntity);
        List<LibraryxqEntity> libraryxqEntities=new ArrayList<>();
        for (Allotxq allotxq : allotxqList) {
            StojlEntity stojlEntity = new StojlEntity(stoEntity,allotxq.getProductName(),allotxq.getProductId(),allotxq.getProductFl(),allotxq.getSl(),allotxq.getPh(),allotxq.getBz(),allotxq.getGe(),allotxq.getGys(),allotxq.getPrice(),allotxq.getScdate(),allotxq.getGqdate(),allotxq.getKszt(),allotxq.getGesl(),allotxq.getShdw());
            rkxqDao.save(stojlEntity);
            LibraryxqEntity ckxqcxid = cangkMapper.ckxqcxid(allot.getLibrary().getLibraryId(), allotxq.getProductId(), allotxq.getProductFl(), allotxq.getPh());
            if(ckxqcxid==null){
                long sjprice=0l;
                if(stojlEntity.getProductFl().equals("0")){
                    DrugEntity ypcxid = ypMapper.ypcxid(stojlEntity.getProductId());
                    sjprice=ypcxid.getDrugPrice();
                }else{
                    ConEntity concxid = conMapper.concxid(stojlEntity.getProductId());
                    sjprice=concxid.getConPrice();
                }

                ckxqcxid=new LibraryxqEntity(stojlEntity.getProductId(),stojlEntity.getProductName(),stojlEntity.getProductFl(),stojlEntity.getSl(),stojlEntity.getPh(),stojlEntity.getScdate(),stojlEntity.getGqdate(),stoEntity.getLibrary(),stojlEntity.getPrice()
                        ,stojlEntity.getGe(),stojlEntity.getSl(),stojlEntity.getGys(),sjprice,stojlEntity.getKszt(),stojlEntity.getGesl(),stojlEntity.getShdw());

                int f=0;
                for (LibraryxqEntity libraryxqEntity : libraryxqEntities) {
                    if(libraryxqEntity.getProductId().equals(ckxqcxid.getProductId()) && libraryxqEntity.getProductFl().equals(ckxqcxid.getProductFl()) && libraryxqEntity.getPh().equals(ckxqcxid.getPh())){
                        f=1;
                        libraryxqEntity.setKcs(ckxqcxid.getKcs()+libraryxqEntity.getKcs());
                    }
                }
                if(f==0){
                    libraryxqEntities.add(ckxqcxid);
                }else {
                    f=0;
                }
                System.out.println("新增仓库记录");
            }else{
                ckxqcxid.setKcs(ckxqcxid.getKcs()+allotxq.getSl());
                cankxqDao.save(ckxqcxid);
            }

        }

        for (LibraryxqEntity libraryxqEntity : libraryxqEntities) {
            cankxqDao.save(libraryxqEntity);
        }
        allot.setZt(1);
        dbDao.save(allot);
        auditInfoDao.save(auditInfo);
    }

    public void bh(Allot allot,AuditInfo auditInfo){
        allot.setZt(2);
        dbDao.save(allot);
        auditInfoDao.save(auditInfo);
    }

    public void tjsh(Allot allot){
        allot.setZt(3);
        dbDao.save(allot);
    }
}
