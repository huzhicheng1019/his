package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.PrepayMapper;
import cn.gson.his.model.pojos.InHospital.PrepayDetailsEntity;
import cn.gson.his.model.pojos.InHospital.PrepayEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PrepayService {
    @Autowired
    PrepayMapper prepayMapper;

    //新增押金缴费表
    public int insertPre(PrepayEntity prepay, PrepayDetailsEntity prepayDetails){
        //添加押金表
        prepayMapper.insertPre(prepay);
        //将押金表主键返回给详表
        prepayDetails.setPreId(prepay.getPreId());
        //添加押金详表
        return prepayMapper.insertPres(prepayDetails);
    }

    //查询所有押金表
    public List<PrepayEntity> selPre(String content){
        return prepayMapper.selPre(content);
    };

    //修改押金表余额
    public int updatePre(PrepayEntity prepay){
        return prepayMapper.updatePre(prepay);
    };
}
