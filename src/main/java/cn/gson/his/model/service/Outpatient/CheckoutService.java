package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.ChangepartMapper;
import cn.gson.his.model.mappers.Outpatient.CheckoutMapper;
import cn.gson.his.model.pojos.Outpatient.ChangepartEntity;
import cn.gson.his.model.pojos.Outpatient.CheckoutEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CheckoutService {
    //化验主表
    @Autowired CheckoutMapper checkoutMapper;

    @Autowired ChangepartMapper changepartMapper;

    //新增化验单
    @Transactional
    public void addCheck(CheckoutEntity checkoutEntity, List<ChangepartEntity> change){
            //新增主表
            checkoutMapper.addCheck(checkoutEntity);
            // 新增详情
             change.forEach(d->{
                 d.setCheckoutNo(checkoutEntity.getCheckoutNo());
                 changepartMapper.addChangepart(d);
             });
    }
    //修改化验收费状态
    public void upCheck(Integer checkoutState,Integer checkoutId){
                checkoutMapper.upCheck(checkoutState,checkoutId);

    }
    //查询化验
    public List<ChangepartEntity> allChang(String checkoutId){
        return changepartMapper.allChangepart(checkoutId);
    }

}