package com.onlineExam.util;


import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static long ND = 1000 * 24 * 60 * 60;

    private static long NH = 1000 * 60 * 60;

    private static long NM = 1000 * 60;

    public final static String DATE = "yyyy-MM-dd";

    public final static String TIME = "HH:mm:ss";

    public final static String DATETIME = "yyyy-MM-dd HH:mm:ss";

    public final static String DATEYEAR = "yyyy";

    public static Date StringToDate(String date,String dateFormat){
        if (date == null || StringUtils.isEmpty(date.trim())) return null;
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        Date now;
        try {
            now = sf.parse(date);
        }catch (Exception e){
            throw new RuntimeException("日期格式转换不匹配",e);
        }
        return now;
    }

    public static String DateToString(Date date,String dateFormat){
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        String now;
        try {
            now = sf.format(date);
        }catch (Exception e){
            throw new RuntimeException("日期格式转换不匹配",e);
        }
        return now;
    }

    public static Integer getAge(Date date){
        return getCurrentAge(new Date(),date);
    }

    public static Integer getCurrentAge(Date toDate,Date fromDate){
        String nowYear = DateUtil.DateToString(toDate,"yyyy").replace("-","");
        String oldYear = DateUtil.DateToString(fromDate,"yyyy").replace("-","");
        return Integer.valueOf(String.valueOf(new BigDecimal(nowYear).subtract(new BigDecimal(oldYear).add(new BigDecimal(1)))));
    }

    public static String getDistance(Date date1,Date date2){
        Long diff = date2.getTime() - date1.getTime();
        if (diff > 0) {
            Long min = diff / NM;
            long minute = min / 60;
            long second = min % 60;
            String minStr = minute + "";
            String secStr = second + "";
            if (minute < 10L){
                minStr = "0" + minStr;
            }
            if (second < 10L){
                secStr = "0" + secStr;
            }
            return minStr + ":" + secStr;
        }else
            return "--:--";
    }
}
