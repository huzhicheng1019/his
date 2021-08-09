package cn.gson.his.model.service.Checkout;

import cn.gson.his.model.mappers.Checkout.Operation_itemsMapper;
import cn.gson.his.model.pojos.Checkout.ItemVo;
import cn.gson.his.model.pojos.Checkout.OperationItemEntity;
import cn.gson.his.model.pojos.Checkout.HcEntity;
import cn.gson.his.model.pojos.Checkout.YpEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Operation_itemsService {
    @Autowired
    Operation_itemsMapper operation_itemsMapper;

    //查询所有手术项目
    public PageInfo selectitems(Integer no,Integer size){
        PageHelper.startPage(no,size);
        List<OperationItemEntity> list = operation_itemsMapper.selectitems();
        PageInfo<OperationItemEntity> info = new PageInfo<>(list);
        return info;
    }

    //删除手术项目
    public Integer delitems1(Integer id){
        return operation_itemsMapper.delitems1(id);
    }


    //删除手术项目
    public Integer delitems2(Integer id){
        return operation_itemsMapper.delitems2(id);
    }

    //删除手术项目
    public Integer delitems3(Integer id){
        return operation_itemsMapper.delitems3(id);
    }

    //查询所有药品 带分页
    public PageInfo seldrug(Integer no, Integer size){
        PageHelper.startPage(no, size);
        List<YpEntity> list = operation_itemsMapper.seldrug();
        PageInfo<YpEntity> info=new PageInfo<>(list);
        return info;
    }

    //查询所有耗材 带分页
    public PageInfo selcon(Integer no, Integer size){
        PageHelper.startPage(no, size);
        List<HcEntity> list = operation_itemsMapper.selcon();
        PageInfo<HcEntity> info=new PageInfo<>(list);
        return info;
    }

    //新增手术项目
    public Integer insertoperation(ItemVo itemVo){
        return operation_itemsMapper.insertoperation(itemVo);
    }

    //新增药品中间表
    public Integer insertdrug(Integer dNum,Integer dPrice,Integer a,Integer b){
        return operation_itemsMapper.insertdrug(dNum, dPrice, a, b);
    }

    //新增耗材中间表
    public Integer insertcon( Integer consumablesNum,Integer consumablesPrice,Integer a1, Integer b1){
        return operation_itemsMapper.insertcon(consumablesNum, consumablesPrice, a1, b1);
    }
}
