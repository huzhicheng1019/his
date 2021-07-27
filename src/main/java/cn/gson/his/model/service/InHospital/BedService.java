package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.BedMapper;
import cn.gson.his.model.pojos.InHospital.BedEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class BedService {
    @Autowired
    BedMapper bedMapper;

    //根据id查询所有床位
    public List<BedEntity> selectBed(String roomId){
        return bedMapper.selectBed(roomId);
    }
    //新增床位
    public int insertBed(BedEntity bedEntity){
        return bedMapper.insertBed(bedEntity);
    }

    //修改床位
    public int updateBed(BedEntity bedEntity){
        return bedMapper.updateBed(bedEntity);
    }

    //根据床位id查所属病房
    public BedEntity selIdBed(String bedId){
        return bedMapper.selIdBed(bedId);
    };

    //修改床位状态
    public int updateStatus(String bedIs,String bedId){
        return bedMapper.updateStatus(bedIs,bedId);
    };
}
