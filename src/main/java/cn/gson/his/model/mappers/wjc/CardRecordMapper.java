package cn.gson.his.model.mappers.wjc;

import cn.gson.his.model.pojos.wjc.CardrecordEntity;
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

public interface CardRecordMapper {

    //查询就诊卡充值记录
    public List<CardrecordEntity> allCardRecord(CardrecordEntity  cardrecord);

    //新增就诊卡充充值记录
    public int addCardecord(CardrecordEntity cardrecord);


}
