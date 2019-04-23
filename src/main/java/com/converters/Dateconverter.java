package com.converters;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换类
 * 第一个是页面传入的类型
 * 第二个是转换的类型
 */
public class Dateconverter  implements Converter<String, Date>
{

    @Override
    public Date convert(String s) {
        try{
            if(s!= null){
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return simpleDateFormat.parse(s);
            }
        }catch (Exception e){
        }
        return null;
    }
}
