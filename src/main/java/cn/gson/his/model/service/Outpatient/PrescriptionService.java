package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.PrescriptionMapper;
import cn.gson.his.model.pojos.Outpatient.PrescriptionEntity;
import cn.gson.his.model.pojos.Outpatient.PrescriptionsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PrescriptionService {

    @Autowired
    PrescriptionMapper pm;

    @Autowired
    PrescriptionsService pps;


    //新增处方
    //详情一起新增
    @Transactional
    public int addPres(PrescriptionEntity presc, List<PrescriptionsEntity> list){
         try {
             pm.addPres(presc);

             list.forEach(d->{
                 d.setPresId(new PrescriptionEntity());
                 d.getPresId().setPresNo(presc.getPresNo());
                 pps.addprescs(d);
             });
             return 1;
         }catch (Exception e){
             System.out.println(e.fillInStackTrace());
             return 2;
         }



    }


    //查询处方
    public List<PrescriptionEntity> allPres(PrescriptionEntity presc){

        return  pm.allPres(presc);
    }
}
