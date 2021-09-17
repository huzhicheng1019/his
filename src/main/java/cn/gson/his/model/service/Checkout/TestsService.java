package cn.gson.his.model.service.Checkout;

import cn.gson.his.model.mappers.Checkout.TestsMapper;
import cn.gson.his.model.pojos.Checkout.TestDetailsEntity;
import cn.gson.his.model.pojos.Checkout.TestsEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestsService {
    @Autowired
    TestsMapper testsMapper;

    //查询所有检验项目
    public PageInfo selecttests(Integer no,Integer size){
        PageHelper.startPage(no,size);
        List<TestsEntity> list = testsMapper.selecttests();
        PageInfo<TestsEntity> info = new PageInfo<>(list);
        return info;
    }

    //根据id查询项目详情
    public PageInfo selectdetails(Integer id,Integer no,Integer size){
        PageHelper.startPage(no,size);
        List<TestDetailsEntity> list = testsMapper.selectdetails(id);
        PageInfo<TestDetailsEntity> info = new PageInfo<>(list);
        return info;
    }

    //根据id查询项目详情中的内容说明
    public List<TestDetailsEntity> selectshuoming(Integer id){
        return testsMapper.selectshuoming(id);
    }

    //根据id删除检验项目
    public Integer deltests(Integer id){
        return testsMapper.deltests(id);
    }
    public Integer deldetails(Integer id){
        return testsMapper.deldetails(id);
    }

    //新增检验项目
    public Integer inserttest(TestsEntity testsEntity){
        return testsMapper.inserttest(testsEntity);
    }

    //新增检验项目详情
    public Integer insertdetails(TestDetailsEntity testDetailsEntity){
        return testsMapper.insertdetails(testDetailsEntity);
    }
}
