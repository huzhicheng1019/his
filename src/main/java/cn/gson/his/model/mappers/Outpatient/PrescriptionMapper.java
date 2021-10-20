package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.PrescriptionEntity;
import cn.gson.his.model.pojos.Outpatient.SyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface PrescriptionMapper {

    //修改处方收费状态
    public void upPres(@Param("priveType") int priveType,@Param("presNo") int presNo);

    //新增处方
    public int addPres(PrescriptionEntity presc);


    //查询处方
    public PrescriptionEntity allPres(PrescriptionEntity presc);

    //查询所有要缴费的东西
    public List<SyEntity> allSy(String record_id,int state);
    //查询所有要缴费的东西
    public List<SyEntity> SyPrescrip(String record_id);
    //查询检查检验需要缴费的东西
    public List<SyEntity> allJC(String record_id);
    //查询需要缴费的手术
    public List<SyEntity> allOperall(String record_id);
    //查询这个患者所有的化验检查
    public List<SyEntity>sllSYEexamineChange(String record_id);

}
