package cn.gson.his.model.service.Outpatient;


import cn.gson.his.model.mappers.Outpatient.HangMarkMapper;
import cn.gson.his.model.pojos.Outpatient.HangmarkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangMarkService {

     @Autowired
     HangMarkMapper hmm;


//    查询挂号记录
    public List<HangmarkEntity> seleHangMark(HangmarkEntity hang){
        System.out.println("---------------"+hang.getHangDate());
        return hmm.seleHangMark(hang);

    }
//    新增挂号
    public void addHang(HangmarkEntity hang){
        hmm.addHang(hang);
    }
}
