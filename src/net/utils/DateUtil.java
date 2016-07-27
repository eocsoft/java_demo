package net.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	 /**
     * ��ȡʱ���
     * @return
     */
    public static long getTime(){
        //return new Date().getTime();
        return System.currentTimeMillis();
    }

    /**
     * �������ڻ�ȡʱ���
     * @param mDate ���ڸ�ʽΪyyyy-MM-dd hh:mm:ss
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
     * ��� YY-MM-DD
     * @param offset 0==����  1�����һ��  -1��ǰ��һ��
     * @return
     */
    public static String getYMD(int offset){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,offset);
        int year = calendar.get(Calendar.YEAR);//��ȡ���
        int month = calendar.get(Calendar.MONTH)+1;//��ȡ�·�
        int day = calendar.get(Calendar.DATE);//��ȡ��
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
     * �������� ��� YY-MM-DD
     * @param offset 0==����������  1�����һ��  -1��ǰ��һ��
     * @return
     */
    public static String getYMD(String date, int offset){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        if(isDate(date, "yyyy-MM-dd")){
            try {
                calendar.setTime(dateFormat.parse(date));
                calendar.add(Calendar.DAY_OF_MONTH,offset);
                int year = calendar.get(Calendar.YEAR);//��ȡ���
                int month = calendar.get(Calendar.MONTH)+1;//��ȡ�·�
                int day = calendar.get(Calendar.DATE);//��ȡ��
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
     * ��� week
     * @param offset 0==����  1�����һ��  -1��ǰ��һ��
     * @return
     */
    public static String getWeek(int offset){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,offset);
        int weekOfYear = calendar.get(Calendar.DAY_OF_WEEK);
        String week = "";
        switch (weekOfYear){
            case Calendar.MONDAY:
                week = "����һ";
                break;
            case  Calendar.TUESDAY:
                week = "���ڶ�";
                break;
            case Calendar.WEDNESDAY:
                week = "������";
                break;
            case Calendar.THURSDAY:
                week = "������";
                break;
            case Calendar.FRIDAY:
                week = "������";
                break;
            case Calendar.SATURDAY:
                week = "������";
                break;
            case Calendar.SUNDAY:
                week = "������";
                break;
        }
        return week;
    }

    /**
     * �������ڻ�� week
     * @param date   date��ʽΪ"yyyy-MM-dd"
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
     * �ж��Ƿ�Ϊ�Ϸ�������ʱ���ַ���
     * @param str_input
     * @param str_input
     * @return boolean;����Ϊtrue,������Ϊfalse
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
