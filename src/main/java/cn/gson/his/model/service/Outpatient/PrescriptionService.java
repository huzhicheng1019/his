package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.DoctorrecordMapper;
import cn.gson.his.model.mappers.Outpatient.PrescriptionMapper;
import cn.gson.his.model.pojos.Outpatient.DoctorrecordEntity;
import cn.gson.his.model.pojos.Outpatient.PrescriptionEntity;
import cn.gson.his.model.pojos.Outpatient.PrescriptionsEntity;
import cn.gson.his.model.pojos.Outpatient.SyEntity;
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

    @Autowired
    DoctorrecordMapper doct;

    //新增处方
    //详情一起新增
    @Transactional
    public int addPres(PrescriptionEntity presc, List<PrescriptionsEntity> list, DoctorrecordEntity doctorr){
//         try {
             pm.addPres(presc);

             list.forEach(d->{
                 d.setPresId(new PrescriptionEntity());
                 d.getPresId().setPresNo(presc.getPresNo());
                 pps.addprescs(d);
             });
             //修改状态
             doct.upDoctorrecord(doctorr);
             return 1;
//         }catch (Exception e){
//             System.out.println(e.fillInStackTrace());
//             return 2;
//         }



    }


    //查询处方
    public PrescriptionEntity allPres(PrescriptionEntity presc){

        return  pm.allPres(presc);
    }

     public List<SyEntity> allSy(String id){
            return pm.allSy(id);
     }
}
