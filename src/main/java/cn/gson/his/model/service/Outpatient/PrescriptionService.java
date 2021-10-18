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
         try {
             pm.addPres(presc);

             list.forEach(d->{
                 d.setPresId(new PrescriptionEntity());
                 d.getPresId().setPresNo(presc.getPresNo());
                 System.out.println("=========================================================="+presc.getPresNo());
                 pps.addprescs(d);
             });
             //修改状态
             doct.upDoctorrecord(doctorr);
             return 1;
         }catch (Exception e){
             System.out.println(e.fillInStackTrace());
             return 2;
         }



    }


    //查询处方
    public PrescriptionEntity allPres(PrescriptionEntity presc){
        return  pm.allPres(presc);
    }
    //查询所有要缴费的药品
     public List<SyEntity> allSy(String id){
            return pm.allSy(id);
     }
     //查询所有要缴费的检查检验
     public List<SyEntity> allJC(String id){
         return pm.allJC(id);
     }
     //修改处方收费状态
     public void upPres(int priveType,int presNo){
        pm.upPres(priveType,presNo);
     }
    //查询需要缴费的手术
    public List<SyEntity> allOperall(String record_id){
       return pm.allOperall(record_id);
    }
    //查询这个患者所有的化验检查
    public List<SyEntity>sllSYEexamineChange(String record_id){
        return pm.sllSYEexamineChange(record_id);
    }
}
