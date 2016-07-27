package net.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	 /**
     * 获取时间戳
     * @return
     */
    public static long getTime(){
        //return new Date().getTime();
        return System.currentTimeMillis();
    }

    /**
     * 根据日期获取时间戳
     * @param mDate 日期格式为yyyy-MM-dd hh:mm:ss
     * @return
     */
    public static long getTime(String mDate){
        if (isDate(mDate,"yyyy-MM-dd hh:mm:ss")){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String dateString = mDate;
            try {
                Date date  = df.parse(dateString);
                long millisTime = date.getTime();
                return  millisTime;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 获得 YY-MM-DD
     * @param offset 0==当天  1往后加一天  -1往前减一天
     * @return
     */
    public static String getYMD(int offset){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,offset);
        int year = calendar.get(Calendar.YEAR);//获取年份
        int month = calendar.get(Calendar.MONTH)+1;//获取月份
        int day = calendar.get(Calendar.DATE);//获取日
        String temp = year+"";
        if(month < 10){
            temp += "-0"+month;
        }else {
            temp += "-"+month;
        }
        if (day < 10){
            temp += "-0"+day;
        }else {
            temp += "-"+day;
        }
        return temp;
    }

   

    /**
     * 根据日期 获得 YY-MM-DD
     * @param offset 0==传过来日期  1往后加一天  -1往前减一天
     * @return
     */
    public static String getYMD(String date, int offset){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        if(isDate(date, "yyyy-MM-dd")){
            try {
                calendar.setTime(dateFormat.parse(date));
                calendar.add(Calendar.DAY_OF_MONTH,offset);
                int year = calendar.get(Calendar.YEAR);//获取年份
                int month = calendar.get(Calendar.MONTH)+1;//获取月份
                int day = calendar.get(Calendar.DATE);//获取日
                String temp = year+"";
                if(month < 10){
                    temp += "-0"+month;
                }else {
                    temp += "-"+month;
                }
                if (day < 10){
                    temp += "-0"+day;
                }else {
                    temp += "-"+day;
                }
                return temp;
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return "";
    }

  
    /**
     * 获得 week
     * @param offset 0==当天  1往后加一天  -1往前减一天
     * @return
     */
    public static String getWeek(int offset){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,offset);
        int weekOfYear = calendar.get(Calendar.DAY_OF_WEEK);
        String week = "";
        switch (weekOfYear){
            case Calendar.MONDAY:
                week = "星期一";
                break;
            case  Calendar.TUESDAY:
                week = "星期二";
                break;
            case Calendar.WEDNESDAY:
                week = "星期三";
                break;
            case Calendar.THURSDAY:
                week = "星期四";
                break;
            case Calendar.FRIDAY:
                week = "星期五";
                break;
            case Calendar.SATURDAY:
                week = "星期六";
                break;
            case Calendar.SUNDAY:
                week = "星期日";
                break;
        }
        return week;
    }

    /**
     * 根据日期获得 week
     * @param date   date格式为"yyyy-MM-dd"
     * @return
     */
    public static String getWeek(String date){

        if (isDate(date,"yyyy-MM-dd")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat weekFormat = new SimpleDateFormat("E");
            Date d = null;
            try {
                d = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return weekFormat.format(d);
        }
        return "";
    }

   
    /**
     * 判断是否为合法的日期时间字符串
     * @param str_input
     * @param str_input
     * @return boolean;符合为true,不符合为false
     */
    public static  boolean isDate(String str_input,String rDateFormat){
        if (!isNull(str_input)) {
            SimpleDateFormat formatter = new SimpleDateFormat(rDateFormat);
            formatter.setLenient(false);
            try {
                formatter.format(formatter.parse(str_input));
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean isNull(String str){
        if(str==null)
            return true;
        else
            return false;
    }

}
