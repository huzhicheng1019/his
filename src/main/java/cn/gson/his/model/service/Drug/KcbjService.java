package cn.gson.his.model.service.Drug;

import cn.gson.his.model.mappers.Drug.CangkMapper;
import cn.gson.his.model.mappers.Drug.ConMapper;
import cn.gson.his.model.mappers.Drug.YpMapper;
import cn.gson.his.model.pojos.Drug.ConEntity;
import cn.gson.his.model.pojos.Drug.DrugEntity;
import cn.gson.his.model.pojos.Drug.LibraryxqEntity;
import cn.gson.his.model.pojos.Drug.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class KcbjService {
    @Autowired
    YpMapper ypMapper;
    @Autowired
    CangkMapper cangkMapper;
    @Autowired
    ConMapper conMapper;

    //库存报警查询
    public Map<String,Object> kcbjcx(){
        Map<String,Object> map = new HashMap<>();
        List<ProductEntity> productEntityList=new ArrayList<>();
        //所有仓库库存查询
        List<LibraryxqEntity> ckkcbjcx = cangkMapper.ckkcbjcx();
        //药品查询
        DrugEntity drugEntity=new DrugEntity();
        List<DrugEntity> list=ypMapper.selectyp(drugEntity);
        for (DrugEntity entity : list) {
            entity.setZdkcs(0);
            for (LibraryxqEntity libraryxqEntity : ckkcbjcx) {
                if(libraryxqEntity.getProductFl().equals("0") && libraryxqEntity.getProductId().equals(entity.getDrugId())){
                    entity.setZdkcs(entity.getZdkcs()+libraryxqEntity.getKcs());
                }
            }
            System.out.println(entity.getZdkcs());
            ProductEntity productEntity = new ProductEntity(entity.getDrugId(), entity.getDrugName(), "0",entity.getDrugPfprice(), entity.getZdkcs(), entity.getDrugGe(), entity.getGys(), entity.getKszt(), entity.getGesl() , entity.getShdw(), entity.getDw());
            productEntityList.add(productEntity);
        }
        //耗材查询
        ConEntity conEntity = new ConEntity();
        List<ConEntity> concx = conMapper.concx(conEntity);
        for (ConEntity entity : concx) {
            entity.setZdkcs(0);
            for (LibraryxqEntity libraryxqEntity : ckkcbjcx) {
                if(libraryxqEntity.getProductFl().equals("1") && libraryxqEntity.getProductId().equals(entity.getConId())){
                    entity.setZdkcs(entity.getZdkcs()+libraryxqEntity.getKcs());
                }
            }
            ProductEntity productEntity = new ProductEntity(entity.getConId(), entity.getConName(), "1",entity.getDrugPfprice(), entity.getZdkcs(), entity.getConGe(), entity.getGys(), entity.getKszt(), entity.getGesl() , entity.getShdw(), entity.getDw());
            productEntityList.add(productEntity);
        }

        for (int i=1;i<productEntityList.size();i++){
            for (int j=0;j<productEntityList.size()-i;j++){
               if(productEntityList.get(j).getSl()>productEntityList.get(j+1).getSl()){
                    ProductEntity temp;
                    temp=productEntityList.get(j);
                    productEntityList.set(j,productEntityList.get(j+1));
                    productEntityList.set(j+1,temp);
               }
            }

        }
        for (ProductEntity productEntity : productEntityList) {
            System.out.println(productEntity);
        }
        map.put("kcbjcx",productEntityList);
        return map;
    }
}
