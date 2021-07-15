package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.CardEntity;
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
public interface CardMapper {

    //查询就诊卡
    public List<CardEntity> allCard(CardEntity card);
    //新增就诊卡
    public void addCard(CardEntity card);
    //修改就诊卡
    public int upCard(CardEntity card);

}
