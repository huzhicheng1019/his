package cn.gson.his.model.mappers.Checkout;

import cn.gson.his.model.pojos.Checkout.ItemVo;
import cn.gson.his.model.pojos.Checkout.OperationItemEntity;
import cn.gson.his.model.pojos.Checkout.HcEntity;
import cn.gson.his.model.pojos.Checkout.YpEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Operation_itemsMapper {
    //查询所有手术项目
    List<OperationItemEntity> selectitems();

    //删除手术项目
    public Integer delitems1(Integer id);
    //删除手术项目
    public Integer delitems2(Integer id);
    //删除手术项目
    public Integer delitems3(Integer id);

    //查询药品
    public List<YpEntity> seldrug();

    //查询耗材
    public List<HcEntity> selcon();

    // 新增手术项目
    public Integer insertoperation(ItemVo itemVo);

    //新增药品中间表
    public Integer insertdrug(@Param("dNum") Integer dNum,@Param("dPrice") Integer dPrice,@Param("a") Integer a,@Param("b") Integer b);

    //新增耗材中间表
    public Integer insertcon(@Param("consumablesNum") Integer consumablesNum,@Param("consumablesPrice") Integer consumablesPrice,@Param("a") Integer a,@Param("b") Integer b);

}
