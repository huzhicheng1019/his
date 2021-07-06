package cn.gson.his.common;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertor implements Converter<String,Date> {
    public void setPatterns(String[] patterns) {
        this.patterns = patterns;
    }
    //当前转换器能够处理的字符串的格式
    private String[] patterns={
            "yyyy/MM/dd",
            "yyyy-MM-dd",
            "yyyy-MM-dd HH:mm:ss"
    };
    SimpleDateFormat sdf = new SimpleDateFormat();

    @Override
    public Date convert(String source) {
        Date date = null;
        //遍历数组，将数组元素作为格式传递sdf
        for(String pattern:patterns){
            //应用格式
            sdf.applyPattern(pattern);
            try {
                date=sdf.parse(source);
                break;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(date==null){
            System.out.println("转换失败，格式不匹配");
        }else{
            System.out.println("转换成功");
        }
        return date;
    }
}
