package cn.gson.his.model.service.Drug;

import cn.gson.his.model.dao.Drug.CangkDao;
import cn.gson.his.model.dao.Drug.CankxqDao;
import cn.gson.his.model.dao.Drug.RkDao;
import cn.gson.his.model.dao.Drug.RkxqDao;
import cn.gson.his.model.mappers.Drug.*;
import cn.gson.his.model.pojos.Drug.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class RkService {
    @Autowired
    RkMapper rkMapper;

    @Autowired
    CangkMapper cangkMapper;

    @Autowired
    CgMapper cgMapper;

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

    public Map<String, Object> rkcx(int pageNo, int size,String why, String nr, Date qssj, Date jssj){
        Map<String,Object> map = new HashMap<>();
        //分页查询
        Page<Object> page= PageHelper.startPage(pageNo,size);
        map.put("rows",rkMapper.rkcx(why,nr,qssj,jssj));
        map.put("total",page.getTotal());
        return map;
    }

    public Map<String, Object> rkxqcx(Integer id, String nr){
        Map<String,Object> map = new HashMap<>();
        map.put("rows",rkMapper.stojlcx(id,nr));
        return map;
    }

    public Map<String,Object> xzrkxx(Integer id, String nr){
        Map<String,Object> map = new HashMap<>();
        map.put("rk",rkMapper.rkcxid(id));
        map.put("rkxq",rkMapper.stojlcx(id, nr));
        return map;
    }

    public Map<String,Object> ck(){
        Map<String,Object> map = new HashMap<>();
        map.put("ck",cangkMapper.cangkcx(""));
        return map;
    }

    public Map<String,Object> cgcx(String nr){
        Map<String,Object> map = new HashMap<>();
        map.put("cg",cgMapper.rkcgcx(nr));
        return map;
    }

    public Map<String,Object> cgxqcx(String id,String fl){
        Map<String,Object> map = new HashMap<>();
        List<OrderxqEntity> cgxq=new ArrayList<>();

        List<StoEntity> cgrkxs = rkMapper.cgrkxs(id);

        if(fl.equals("0")){
            cgxq = cgMapper.cgxqfl(id, fl);
        }else if(fl.equals("1")){
            cgxq = cgMapper.cgxqfl(id, fl);
        }else if(fl.equals("2")){
            cgxq = cgMapper.cgxqcx(id,"");
        }

        for (OrderxqEntity orderxqEntity : cgxq) {
            for (StoEntity cgrkx : cgrkxs) {
                List<StojlEntity> stojlcx = rkMapper.stojlcx(cgrkx.getStoId(), "");
                for (StojlEntity stojlEntity : stojlcx) {
                    if(orderxqEntity.getProductId().equals(stojlEntity.getProductId()) && orderxqEntity.getProductFl().equals(stojlEntity.getProductFl())){
                        orderxqEntity.setSl(orderxqEntity.getSl()-stojlEntity.getSl()/stojlEntity.getGesl());
                    }
                }
            }
        }
        for (int i=0;i<cgxq.size();i++){
            if(cgxq.get(i).getSl()<=0){
                cgxq.remove(cgxq.get(i));
                i--;
            }
        }
        map.put("cgxq",cgxq);
        return map;
    }

    public void xzsto(StoEntity stoEntity, List<StojlEntity> stojlEntityList){
        rkDao.save(stoEntity);
        for (StojlEntity stojlEntity : stojlEntityList) {
            stojlEntity.setSto(stoEntity);
            Calendar c=Calendar.getInstance();
            c.setTimeInMillis(stojlEntity.getScdate().getTime());
            if(stojlEntity.getProductFl().equals("0")){
                DrugEntity ypcxid = ypMapper.ypcxid(stojlEntity.getProductId());
                c.add(Calendar.MONTH,ypcxid.getBzq());
            }else if (stojlEntity.getProductFl().equals("1")){
                ConEntity concxid = conMapper.concxid(stojlEntity.getProductId());
                c.add(Calendar.MONTH,concxid.getBzq());
            }
            Timestamp timestamp = new Timestamp(c.getTimeInMillis());
            stojlEntity.setGqdate(timestamp);
            System.out.println(stojlEntity.getGqdate());

            rkxqDao.save(stojlEntity);
        }
        List<LibraryxqEntity> ckxqcx = cangkMapper.ckxqcx(stoEntity.getLibrary().getLibraryId(), "");

        int e=0;

        for (int i=0;i<stojlEntityList.size();i++){
            System.out.println(ckxqcx.size());
            for (int j=0;j<ckxqcx.size();j++){
                System.out.println(ckxqcx.get(j));
                if(ckxqcx.get(j).getProductId().equals(stojlEntityList.get(i).getProductId()) && ckxqcx.get(j).getProductFl().equals(stojlEntityList.get(i).getProductFl()) && ckxqcx.get(j).getPh().equals(stojlEntityList.get(i).getPh())){
                    e=1;
                    System.out.println("那里");
                    ckxqcx.get(j).setKcs(ckxqcx.get(j).getKcs()+stojlEntityList.get(i).getSl());
                    cankxqDao.save(ckxqcx.get(j));
                }
            }
            if(e==0){
                System.out.println(e);
                System.out.println("这里");
                Long price=0l;
                Long sjprice=0l;
                GysEntity gysEntity=new GysEntity();

                if(stojlEntityList.get(i).getProductFl().equals("0")){
                    DrugEntity ypcxid = ypMapper.ypcxid(stojlEntityList.get(i).getProductId());
                    price=ypcxid.getDrugPfprice();
                    sjprice=ypcxid.getDrugPrice();
                    gysEntity=ypcxid.getGys();
                }else if (stojlEntityList.get(i).getProductFl().equals("1")){
                    ConEntity concxid = conMapper.concxid(stojlEntityList.get(i).getProductId());
                    price=concxid.getDrugPfprice();
                    sjprice=concxid.getConPrice();
                    gysEntity=concxid.getGys();
                }
                LibraryxqEntity libraryxqEntity=new LibraryxqEntity(stojlEntityList.get(i).getProductId(),stojlEntityList.get(i).getProductName(),stojlEntityList.get(i).getProductFl(),stojlEntityList.get(i).getSl(),stojlEntityList.get(i).getPh(),stojlEntityList.get(i).getScdate(),stojlEntityList.get(i).getGqdate(),stoEntity.getLibrary(),price,stojlEntityList.get(i).getGe(),0,gysEntity,sjprice,stojlEntityList.get(i).getKszt(),stojlEntityList.get(i).getGesl(),stojlEntityList.get(i).getShdw());
                cankxqDao.save(libraryxqEntity);
            }
            e=0;
        }

    }
}
