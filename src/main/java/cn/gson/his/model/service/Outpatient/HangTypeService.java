package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.HangTypeMapper;
import cn.gson.his.model.pojos.Outpatient.HangtypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangTypeService {

    @Autowired
    private HangTypeMapper htm;
    //查询挂号类型
    public List<HangtypeEntity> allHangType(){
        return  htm.allHangType();
    }
}
