/*
 *  Copyright (c) 2013 The CCP project authors. All Rights Reserved.
 *
 *  Use of this source code is governed by a Beijing Speedtong Information Technology Co.,Ltd license
 *  that can be found in the LICENSE file in the root of the web site.
 *
 *   http://www.cloopen.com
 *
 *  An additional intellectual property rights grant can be found
 *  in the file PATENTS.  All contributing project authors may
 *  be found in the AUTHORS file in the root of the source tree.
 */
package com.xyt.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DateUtil {

    /**
     * 变量：日期格式化类型 - 格式:yyyy/MM/dd
     *
     * @since 1.0
     */
    public static final int DEFAULT = 0;

    /**
     * 变量：日期格式化类型 - 格式:yyyy/MM
     *
     * @since 1.0
     */
    public static final int YM = 1;

    /**
     * 变量：日期格式化类型 - 格式:yyyy-MM-dd
     *
     * @since 1.0
     */
    public static final int YMR_SLASH = 11;

    /**
     * 变量：日期格式化类型 - 格式:yyyyMMdd
     *
     * @since 1.0
     */
    public static final int NO_SLASH = 2;

    /**
     * 变量：日期格式化类型 - 格式:yyyyMM
     *
     * @since 1.0
     */
    public static final int YM_NO_SLASH = 3;

    /**
     * 变量：日期格式化类型 - 格式:yyyy/MM/dd HH:mm:ss
     *
     * @since 1.0
     */
    public static final int DATE_TIME = 4;

    /**
     * 变量：日期格式化类型 - 格式:yyyyMMddHHmmss
     *
     * @since 1.0
     */
    public static final int DATE_TIME_NO_SLASH = 5;

    /**
     * 变量：日期格式化类型 - 格式:yyyy/MM/dd HH:mm
     *
     * @since 1.0
     */
    public static final int DATE_HM = 6;

    /**
     * 变量：日期格式化类型 - 格式:HH:mm:ss
     *
     * @since 1.0
     */
    public static final int TIME = 7;

    /**
     * 变量：日期格式化类型 - 格式:HH:mm
     *
     * @since 1.0
     */
    public static final int HM = 8;

    /**
     * 变量：日期格式化类型 - 格式:HHmmss
     *
     * @since 1.0
     */
    public static final int LONG_TIME = 9;
    /**
     * 变量：日期格式化类型 - 格式:HHmm
     *
     * @since 1.0
     */

    public static final int SHORT_TIME = 10;

    /**
     * 变量：日期格式化类型 - 格式:yyyy-MM-dd HH:mm:ss
     *
     * @since 1.0
     */
    public static final int DATE_TIME_LINE = 12;

    /**
     * 变量：日期格式化类型 - 格式:yyyy
     *
     * @since 1.0
     */

    public static Date strToDateLong(String strDate) {
    	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	   ParsePosition pos = new ParsePosition(0);
    	   Date strtodate = formatter.parse(strDate, pos);
    	   return strtodate;
    }

    public static final int DATE_TIME_YEAR = 13;

    public static String dateToStr(Date date,String pattern) {
       if (date == null)
    	 return null;
       SimpleDateFormat formatter = new SimpleDateFormat(pattern);
       return formatter.format(date);
    }

    public static String dateToStr(Date date) {
        return dateToStr(date, "yyyy/MM/dd");
    }
    public static long getTime(String time) throws ParseException{
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    	long times=sdf.parse(time).getTime();
    	return times;
    }
    public static String dateToStr(Date date, int type) {
        switch (type) {
        case DEFAULT:
            return dateToStr(date);
        case YM:
            return dateToStr(date, "yyyy/MM");
        case NO_SLASH:
            return dateToStr(date, "yyyyMMdd");
        case YMR_SLASH:
        	return dateToStr(date, "yyyy-MM-dd");
        case YM_NO_SLASH:
            return dateToStr(date, "yyyyMM");
        case DATE_TIME:
            return dateToStr(date, "yyyy/MM/dd HH:mm:ss");
        case DATE_TIME_NO_SLASH:
            return dateToStr(date, "yyyyMMddHHmmss");
        case DATE_HM:
            return dateToStr(date, "yyyy/MM/dd HH:mm");
        case TIME:
            return dateToStr(date, "HH:mm:ss");
        case HM:
            return dateToStr(date, "HH:mm");
        case LONG_TIME:
            return dateToStr(date, "HHmmss");
        case SHORT_TIME:
            return dateToStr(date, "HHmm");
        case DATE_TIME_LINE:
            return dateToStr(date, "yyyy-MM-dd HH:mm:ss");
        case DATE_TIME_YEAR:
        	return dateToStr(date, "yyyy");
        default:
            throw new IllegalArgumentException("Type undefined : " + type);
        }
    }
    public static Date strToDate(String date,String pattern){
        if (date == null)
        	return null;
        SimpleDateFormat ft = new SimpleDateFormat(pattern);
    	try {
			return ft.parse(date);
		} catch (ParseException e) {
			return null ;
		}
    }

    public static Date strToDate(String date){
         return strToDate(date, "yyyy/MM/dd");
    }
    public static Date strToDate(String date, int type){
        switch (type) {
        case DEFAULT:
            return strToDate(date);
        case YM:
            return strToDate(date, "yyyy/MM");
        case NO_SLASH:
            return strToDate(date, "yyyyMMdd");
        case YMR_SLASH:
        	return strToDate(date, "yyyy-MM-dd");
        case YM_NO_SLASH:
            return strToDate(date, "yyyyMM");
        case DATE_TIME:
            return strToDate(date, "yyyy/MM/dd HH:mm:ss");
        case DATE_TIME_NO_SLASH:
            return strToDate(date, "yyyyMMddHHmmss");
        case DATE_HM:
            return strToDate(date, "yyyy/MM/dd HH:mm");
        case TIME:
            return strToDate(date, "HH:mm:ss");
        case HM:
            return strToDate(date, "HH:mm");
        case LONG_TIME:
            return strToDate(date, "HHmmss");
        case SHORT_TIME:
            return strToDate(date, "HHmm");
        case DATE_TIME_LINE:
            return strToDate(date, "yyyy-MM-dd HH:mm:ss");
        case DATE_TIME_YEAR:
        	return strToDate(date, "yyyy");
        default:
            throw new IllegalArgumentException("Type undefined : " + type);
        }
    }
    public static Date getCurrentDate() throws ParseException{
    	return new Date();

    }
    @SuppressWarnings("static-access")
	public static String getYstdDate(){
    	Calendar cl = Calendar.getInstance();
    	cl.add(cl.DATE, -1);
    	return dateToStr(cl.getTime(),NO_SLASH);
    }
    @SuppressWarnings("static-access")
	public static String getLastYear(){
    	Calendar cl = Calendar.getInstance();
    	cl.add(cl.YEAR, -1);
    	return dateToStr(cl.getTime(),DATE_TIME_YEAR);
    }

    public static long compare(Date date1,Date date2,long interval){
    	return date2.getTime()+interval-date1.getTime();
    }
    @SuppressWarnings("static-access")
	public static String getTdDate(){
        Calendar cl = Calendar.getInstance();
        cl.add(cl.DATE,0);
        return dateToStr(cl.getTime(),YMR_SLASH);
    }

    /**
     * 获取今天往后days天数日期（yyyy-MM-dd）
     * @param days  可为负数
     * @return
     */
    public static String getDate(int days){
        Calendar cl = Calendar.getInstance();
        cl.add(cl.DATE,days);
        return dateToStr(cl.getTime(),YMR_SLASH);
    }

    public static String getMonthFirstDay(){
        Calendar cl =Calendar.getInstance();//获取当前日期
        cl.add(Calendar.MONTH, 0);
        cl.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        return dateToStr(cl.getTime(),YMR_SLASH);
    }

    public static List<Date> getBetweenDate(Date beginDate, Date endDate) {
        if(beginDate.getTime() == endDate.getTime()){
            return null;
        }
        List lDate = new ArrayList();
        lDate.add(beginDate);//把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        //使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            //根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(cal.getTime());
            } else {
                break;
            }
        }
        lDate.add(endDate);//把结束时间加入集合
        return lDate;
    }

    public static List<String> getStrBetweenDate(String beginStrDate, String endStrDate) {
        Date beginDate = strToDate(beginStrDate,YMR_SLASH);
        Date endDate = strToDate(endStrDate,YMR_SLASH);
        if(beginDate.getTime() == endDate.getTime()){
            return null;
        }
        List lDate = new ArrayList();
        lDate.add(beginStrDate);//把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        //使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            //根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(dateToStr(cal.getTime(),YMR_SLASH));
            } else {
                break;
            }
        }
        lDate.add(endStrDate);//把结束时间加入集合
        return lDate;
    }
}
