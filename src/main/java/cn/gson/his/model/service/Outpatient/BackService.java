package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.BackMapper;
import cn.gson.his.model.pojos.Outpatient.BackEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackService {
    @Autowired
    private BackMapper bm;


    //新增退号表
    public void addBack(BackEntity back){
        bm.addBack(back);
    }
    //查询退号表
    public List<BackEntity> seleBack(BackEntity back){
        return bm.seleBack(back);
    }
}
