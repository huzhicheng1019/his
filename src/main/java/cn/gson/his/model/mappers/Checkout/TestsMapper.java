package cn.gson.his.model.mappers.Checkout;

import cn.gson.his.model.pojos.Checkout.TestDetailsEntity;
import cn.gson.his.model.pojos.Checkout.TestsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestsMapper {
    //查询所有检验项目
    public List<TestsEntity> selecttests();

    //根据id查询项目详情
    public List<TestDetailsEntity> selectdetails(Integer id);

    //根据id查询项目详情中的内容说明
    public List<TestDetailsEntity> selectshuoming(Integer id);

    //根据id删除检验项目
    public Integer deltests(Integer id);
    public Integer deldetails(Integer id);

    //新增化验项目
    public Integer inserttest(TestsEntity testsEntity);

    //新增化验项目详情
    public Integer insertdetails(TestDetailsEntity testDetailsEntity);
}
