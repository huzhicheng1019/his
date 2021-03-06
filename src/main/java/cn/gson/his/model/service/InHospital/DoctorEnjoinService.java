package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.BedsMapper;
import cn.gson.his.model.mappers.InHospital.DoctorEnjoinMapper;
import cn.gson.his.model.mappers.InHospital.DoctorExecuteMapper;
import cn.gson.his.model.mappers.InHospital.PrepayMapper;
import cn.gson.his.model.pojos.InHospital.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DoctorEnjoinService {
    //医嘱mapper
    @Autowired
    DoctorEnjoinMapper doctorEnjoinMapper;

    //医嘱执行记录mapper
    @Autowired
    DoctorExecuteMapper exe;

    //床位记录mapper
    @Autowired
    BedsMapper beds;

    //押金表mapper
    @Autowired
    PrepayMapper prepay;



    //新增医嘱表
    public int insertEn(DoctorEnjoinEntity en){

        doctorEnjoinMapper.insertEn(en);

        List<DoctorEnjoinsEntity> doctorEnjoins = en.getAdvice();

        for (DoctorEnjoinsEntity d: doctorEnjoins) {
            d.setEnId(en.getEnId());
            d.setEnsStart(en.getEnStart());
        }

        return doctorEnjoinMapper.insertEns(doctorEnjoins);

    }



    //根据住院号查医嘱
    public List<DoctorEnjoinEntity> selEn(String regMark){
        return doctorEnjoinMapper.selEn(regMark);
    };

    //修改医嘱状态连着详表一起修改
    public int updateEn(String enId){
        doctorEnjoinMapper.updateEn(enId);
       return doctorEnjoinMapper.updateEns(enId);
    }

    //单独修医嘱详表状态
    public int upEns(String ensId,String regMark){

        int i = doctorEnjoinMapper.upEns(ensId);

        int a = 0;
        int b = 0;
        int c = 0;
        //根据住院号查
        List<DoctorEnjoinEntity> doctorEnjoin = doctorEnjoinMapper.selEn(regMark);
        for (DoctorEnjoinEntity s: doctorEnjoin) {

            b = s.getEnId();

            List<DoctorEnjoinsEntity> advice = s.getAdvice();

            c = advice.size();

            for (DoctorEnjoinsEntity d: advice) {
                if(d.getEnsEnd() != null ){
                    a++;
                }

            }

        }
        if(a == c){
            doctorEnjoinMapper.updateEn(b+"");
        }
        return i;
    }


    //执行医嘱查询
    public List<DoctorEnjoinEntity> execute(String regMark){
        return  doctorEnjoinMapper.execute(regMark);
    };

    //查询当天的医嘱执行记录
    public List<DoctorExecuteEntity> queryRecord(@Param("text")String text, @Param("depaId") String depaId){
        return exe.queryRecord(text,depaId);
    }

    //确认执行医嘱  新增执行记录 并扣费
    public int carryout(String regMark){
        //根据住院号查床位记录
        BedsEntity bedsEntity = beds.selBeds(regMark);

        //创建执行记录对象
        DoctorExecuteEntity execute = new DoctorExecuteEntity();

        //根据住院号押金表对象
        PrepayEntity prepayEntity = prepay.selectPre(regMark);

        //接受所有金额
        double price = 0;

        //根据住院号查所有医嘱详表
        List<DoctorEnjoinEntity> enjoin = doctorEnjoinMapper.execute(regMark);
        for (DoctorEnjoinEntity d: enjoin) {

            if(d.getEnType() == 2){
                doctorEnjoinMapper.updateEn(d.getEnId()+"");
                doctorEnjoinMapper.updateEns(d.getEnId()+"");
            }

            List<DoctorEnjoinsEntity> enjoins = d.getAdvice();
            for (DoctorEnjoinsEntity ds: enjoins) {
                for(int i=0; i<ds.getEnsAmount(); i++){

                    execute.setEnsId(ds.getEnsId());
                    execute.setNurseId(bedsEntity.getNurseId());
                    execute.setNurseName(bedsEntity.getNurseName());
                    execute.setRegMark(regMark);
                    execute.setDrugId(ds.getDrugId());
                    execute.setDrugName(ds.getDrugName());
                    execute.setDrugGe(ds.getDrugGe());
                    execute.setDrugDw(ds.getDrugDw());
                    execute.setDrugCount(ds.getEnsCount());
                    execute.setDrugPrice(ds.getDrugPrice());

                    price += ds.getDrugPrice()*ds.getEnsCount();

                    //新增执行记录
                    System.out.println("执行记录");
                    System.out.println(execute);
                    exe.insertExe(execute);
                }
            }
        }

        prepayEntity.setPreBalance(price);
        //修改余额
        prepay.updateMoney(prepayEntity);
        //新增扣费记录
        PrepayDetailsEntity prepays = new PrepayDetailsEntity();
        prepays.setPresPrice(price);
        prepays.setItemId(0);
        prepays.setPresType(1);
        prepays.setPreId(prepayEntity.getPreId());
        prepays.setPreText("医嘱扣费");
        int i = prepay.insertPres(prepays);

        if(i >0 ){
            return 1;
        }
        return 0;
    };


    //根据住院号查医嘱执行记录
    public List<DoctorExecuteEntity> regSel(String regMark){
        return exe.regSel(regMark);
    }


}
