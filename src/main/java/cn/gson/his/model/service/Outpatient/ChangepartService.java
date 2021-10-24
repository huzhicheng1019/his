package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.ChangepartMapper;
import cn.gson.his.model.pojos.Outpatient.ChangepartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangepartService {

    @Autowired ChangepartMapper changepartMapper;



    //查询化验
    public void allChangepart(String checkoutId){
        changepartMapper.allChangepart(checkoutId);
    }

    //修改化验
    public void upChangepart(String result,Integer checkout){
        changepartMapper.upChangepart(result,checkout);
    }
    //查询缴费了的检查化验
    public List<ChangepartEntity> seleCheckJF(String checkoutId){
        return  changepartMapper.seleCheckJF(checkoutId);
    }
    //修改是否填写结果
    public int upChangepartJG(int state,int changepartNo){
       return changepartMapper.upChangepartJG(state,changepartNo);
    }
    //查询化验结果是否填写
    public List<ChangepartEntity> allChangepartJG(String checkoutId){
            return  changepartMapper.seleCheckJG(checkoutId);
    }
}
