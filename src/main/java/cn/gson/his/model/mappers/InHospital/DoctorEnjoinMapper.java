package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.InHospital.DoctorEnjoinEntity;
import cn.gson.his.model.pojos.InHospital.DoctorEnjoinsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorEnjoinMapper {

    //新增医嘱
    public int insertEn(DoctorEnjoinEntity doctorEnjoin);

    //新增医嘱详表
    public int insertEns(List<DoctorEnjoinsEntity> doctorEnjoins);

    //根据住院号查医嘱
    public List<DoctorEnjoinEntity> selEn(String regMark);


    //修改医嘱状态
    public int updateEn(String enId);
    //修改医嘱详表状态
    public int updateEns(String enId);

    //单独修医嘱详表状态
    public int upEns(String ensId);


    //执行医嘱查询
    public List<DoctorEnjoinEntity> execute(String regMark);

}
