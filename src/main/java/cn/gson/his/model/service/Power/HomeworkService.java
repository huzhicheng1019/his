package cn.gson.his.model.service.Power;

import cn.gson.his.model.mappers.Power.HomeworkMapper;
import cn.gson.his.model.pojos.Power.vo.echarts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class HomeworkService {
    @Autowired
    HomeworkMapper mapper;

    public List<echarts> allHospital(){
        return mapper.allHospital();
    }
}
