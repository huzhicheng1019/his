package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.*;
import cn.gson.his.model.pojos.Drug.DrugEntity;
import cn.gson.his.model.pojos.InHospital.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class HospitalRegisterService {
    @Autowired
    HospitalRegisterMapper hospitalRegisterMapper;
    //出院申请
    @Autowired
    DoctorLeaveMapper doctorLeaveMapper;

    //押金表
    @Autowired
    PrepayMapper prepayMapper;
    //押金详表
    @Autowired
    PrepayDetailsMapper prepayDetailsMapper;
    //床位使用记录
    @Autowired
    BedsMapper bedsMapper;
    //床位表
    @Autowired
    BedMapper bedMapper;





    //新增住院登记
    public int insertReg(HospitalRegisterEntity hospitalRegisterEntity){
        return  hospitalRegisterMapper.insertReg(hospitalRegisterEntity);
    }

    //查询所有住院登记表
    public List<HospitalRegisterEntity> selReg(HospitalRegisterEntity hospitalRegisterEntity){
        String beginTime = null;
        String endTime = null;
        String depaId = "";
        if (hospitalRegisterEntity.getBeginTime() != null && hospitalRegisterEntity.getEndTime() != null ) {
            SimpleDateFormat sf = new SimpleDateFormat("yyy-MM-dd");
            beginTime = sf.format(hospitalRegisterEntity.getBeginTime());
            endTime = sf.format(hospitalRegisterEntity.getEndTime());
        }

        if(hospitalRegisterEntity.getDepaId() != null){
            depaId = hospitalRegisterEntity.getDepaId()+"";
        }

        return hospitalRegisterMapper.selReg(depaId,beginTime,endTime,hospitalRegisterEntity.getContent());
    };

    //查询所有住院登记表 和 床位记录表
    public List<HospitalRegisterEntity> selRegBeds(HospitalRegisterEntity hospitalRegisterEntity){
        String beginTime = null;
        String endTime = null;
        String depaId = "";
        if (hospitalRegisterEntity.getBeginTime() != null && hospitalRegisterEntity.getEndTime() != null ) {
            SimpleDateFormat sf = new SimpleDateFormat("yyy-MM-dd");
            beginTime = sf.format(hospitalRegisterEntity.getBeginTime());
            endTime = sf.format(hospitalRegisterEntity.getEndTime());
        }

        if(hospitalRegisterEntity.getDepaId() != null){
            depaId = hospitalRegisterEntity.getDepaId()+"";
        }

        return hospitalRegisterMapper.selRegBeds(depaId,beginTime,endTime,hospitalRegisterEntity.getContent());
    };

    /**
     * 查询病人所有信息
     */
    public List<HospitalRegisterEntity> selAll(String text,String depaId){
        return hospitalRegisterMapper.selAll(text,depaId);
    };

    //查询执行医嘱
    public List<HospitalRegisterEntity> query(String text,String depaId){
        return hospitalRegisterMapper.query(text, depaId);
    }


    //新增出院申请
    public int insertLea(DoctorLeaveEntity doctorLeave){
        int i = doctorLeaveMapper.insertLea(doctorLeave);
        if (i>0){
            return 1;
        }
        return 0;
    }

    //根据住院号查出院申请单
    public DoctorLeaveEntity selLea(String regMark){
        return  doctorLeaveMapper.selLea(regMark);
    }

    //修改出院申请（取消）
    public int updateLea(String leaReason,String leaId){
        int i =doctorLeaveMapper.updateLea(leaReason,leaId);
        if (i>0){
            return 1;
        }
        return 0;
    }

    //出院登记查询
    public List<HospitalRegisterEntity> selLeave(String text,String depaId){
        return hospitalRegisterMapper.selLeave(text,depaId);
    }


    //转科后修改科室和主治医生
    public int updateReg(HospitalRegisterEntity hospitalRegister){
        return hospitalRegisterMapper.updateReg(hospitalRegister);
    }
    //根据住院号查病人
    public HospitalRegisterEntity look(String regMark){
        return hospitalRegisterMapper.look(regMark);
    }

    //查询所有出院申请
    public List<HospitalRegisterEntity> leaSel(HospitalRegisterEntity hospitalRegisterEntity){
        String beginTime = null;
        String endTime = null;
        String depaId = "";
        if (hospitalRegisterEntity.getBeginTime() != null && hospitalRegisterEntity.getEndTime() != null ) {
            SimpleDateFormat sf = new SimpleDateFormat("yyy-MM-dd");
            beginTime = sf.format(hospitalRegisterEntity.getBeginTime());
            endTime = sf.format(hospitalRegisterEntity.getEndTime());
        }

        if(hospitalRegisterEntity.getDepaId() != null){
            depaId = hospitalRegisterEntity.getDepaId()+"";
        }

        return hospitalRegisterMapper.leaSel(depaId,beginTime,endTime,hospitalRegisterEntity.getContent());
    }


    //确定出院
    public int leave(String regMark,String Tprice){
        //将费用转换成double类型
        double price = Double.parseDouble(Tprice);
        //根据住院号查押金主表
        PrepayEntity prepayEntity = prepayMapper.selectPre(regMark);

        //定义一个押金详表对象
        PrepayDetailsEntity preDet = new PrepayDetailsEntity();

        //如果退费金额大于0 生成退费记录 如果小于0 生成缴费记录 等于0 不生成记录
        if(prepayEntity.getPreBalance() > 0){
            preDet.setPresPrice(price);
            preDet.setItemId(0);
            preDet.setPresType(2);
            preDet.setPreId(prepayEntity.getPreId());
            preDet.setPreText("出院退费");
            prepayDetailsMapper.insertPreDet(preDet);

            //清空押金表余额
            prepayMapper.updatePre2(prepayEntity);

        }
        if(prepayEntity.getPreBalance() < 0){
            preDet.setPresPrice(price);
            preDet.setItemId(0);
            preDet.setPresType(0);
            preDet.setPreId(prepayEntity.getPreId());
            preDet.setPreText("出院缴费");
            prepayDetailsMapper.insertPreDet(preDet);
            //清空押金表余额
            prepayMapper.updatePre2(prepayEntity);
        }

        //根据住院号查床位使用记录
        BedsEntity bedsEntity = bedsMapper.selBeds(regMark);

        if(bedsEntity.getBedId() != 0){
            //修改床位使用记录
            bedsEntity.setBedsEnd(new Timestamp(new Date().getTime()));
            bedsEntity.setBedsIs(2);
            bedsMapper.updateBeds(bedsEntity);
            //修改病床状态
            bedMapper.updateStatus(0+"",bedsEntity.getBedId()+"");
        }

        //根据住院号查住院登记表
        HospitalRegisterEntity look = hospitalRegisterMapper.look(regMark);

        long time = look.getRegDate().getTime();
        long time1 = new Timestamp(new Date().getTime()).getTime();
        long time2=time1-time;
        long p = time2 / 1000 / (60 * 60 * 24);

        //新增出院登记
        DoctorCheckEntity check = new DoctorCheckEntity();
        check.setRegMark(regMark);
        check.setCheName(look.getRegName());
        check.setBedId(bedsEntity.getBedId());
        check.setCheDay((int)p);
        check.setDepaId(look.getDepaId());
        hospitalRegisterMapper.insertCheck(check);

        //修改出院申请表状态
        DoctorLeaveEntity doctorLeaveEntity = doctorLeaveMapper.selLea(regMark);
        doctorLeaveMapper.updateLea("已出院",doctorLeaveEntity.getLeaId()+"");

        //修改住院登记表状态
        int i = hospitalRegisterMapper.updateRegister(regMark);

        if(i>0){
            return 1;
        }
        return 0;
    };



}
