package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CangkMapper {
    public List<LibraryInfoEntity> cangkcx(String nr);

    public List<LibraryxqEntity> ckxqcx(@Param("id") Integer id,@Param("nr") String nr);

    public List<LibraryxqEntity> dbckxqcx(@Param("id") Integer id,@Param("nr") String nr,@Param("ckid") Integer ckid,@Param("ckdj") Integer ckdj);

    public List<LibraryInfoEntity> ckcxid(Integer id);

    public List<StoEntity> stocx(@Param("id") Integer id);

    public List<StojlEntity> stojlcx(@Param("id") Integer id,@Param("proid") Integer proid,@Param("fl") String fl,@Param("ph") String ph);

    public List<ChuEntity> chucx(@Param("id") Integer id);

    public List<ChujlEntity> chujlcx(@Param("id") Integer id,@Param("proid") Integer proid,@Param("fl") String fl,@Param("ph") String ph);

    public List<LibraryInfoEntity> yfckcx();

    public List<LibraryxqEntity> yfcfcx(@Param("id") Integer id,@Param("pid") Integer pid,@Param("fl") String fl);

    public LibraryxqEntity ckxqcxid(@Param("id") Integer id,@Param("pid") Integer pid,@Param("fl") String fl,@Param("ph") String ph);

    public List<LibraryxqEntity> ckgqcx(@Param("id") Integer id);

    public List<LibraryxqEntity> cklqcx(@Param("id") Integer id);

    public List<LibraryxqEntity> ckhscx(@Param("id") Integer id);

    public List<LibraryxqEntity> ckkcbjcx();

    public List<LibraryxqEntity> xhgqcx(String nr);

    public List<LibraryxqEntity> xhlqcx(String nr);

    public List<LibraryxqEntity> xhhscx(String nr);

}
