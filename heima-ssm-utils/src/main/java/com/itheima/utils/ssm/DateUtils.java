package com.itheima.utils.ssm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {
    /**
     * 日期转化成字符串
     * @param date 日期
     * @param pattern 转化格式
     * @return
     */
    public static String DateToString(Date date,String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 字符串转化成日期
     * @param sdate 字符串
     * @param pattern 转化格式
     * @return
     * @throws ParseException
     */
    public static Date StringToDate(String sdate,String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.parse(sdate);
    }
}
