package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Checkout.TestDetailsEntity;
import cn.gson.his.model.pojos.Checkout.TestsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TextsMappper {

    //查询检验检查
    public List<TestsEntity> selectTest(@Param("typeName") String typeName, @Param("jycx")String jycx);

    //新增检验
    public int addTest(TestsEntity testsEntity);
    //新增检验详情
    public int insertdetails(TestDetailsEntity testDetailsEntity);
    //修改是否停用
    public int upTestsDetails(@Param("state") int state,@Param("test") int test);
    //修改检验检查
    public int upTest(TestsEntity testsEntity);
    //修改详情
    public int upDetails(TestDetailsEntity testDetailsEntity);
}
