package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.PrescriptionsMapper;
import cn.gson.his.model.pojos.Outpatient.PrescriptionsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PrescriptionsService {


    @Autowired
    PrescriptionsMapper pres;

    //新增处方详情
    @Transactional
    public int addprescs(PrescriptionsEntity prescs){

        return  pres.addprescs(prescs);
    }
    //查询处方详情
    public List<PrescriptionsEntity> allPrescs(PrescriptionsEntity prescs){
        return  pres.allPrescs(prescs);
    }


}
