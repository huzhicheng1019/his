package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.PatientdataEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 添加了@Mapper注解之后这个接口在编译时会生成相应的实现类
 *
 * 需要注意的是：这个接口中不可以定义同名的方法，因为会生成相同的id
 * 也就是说这个接口是不支持重载的
 * 患者资料mapper层
 */
@Mapper
public interface PatientMapper{

    //查询患者资料
    public List<PatientdataEntity> selePatient(PatientdataEntity patient);
    //查询患者资料
    public List<PatientdataEntity> selePatient1(String cxtj);
    //新增患者资料
    public int AddPatient(PatientdataEntity patient);

    //修改患者信息
    public void UpdatePatient(PatientdataEntity patient);

    //根据id删除患者信息
    public int delPatient(String patientNo);

    //根据身份证查病人资料表
    public PatientdataEntity selID(String patientIdentity);
}
