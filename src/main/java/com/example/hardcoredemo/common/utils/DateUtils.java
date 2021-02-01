package com.example.hardcoredemo.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * <p>
 * 默认使用 "yyyy-MM-dd HH:mm:ss" 格式化日期
 *
 * @version1.0
 */

public final class DateUtils {
    /**
     * 英文简写（默认）如：2010-12-01
     */

    public static String FORMAT_SHORT = "yyyy-MM-dd";

    /**
     * 英文简写（点分割）如：2010.12.01
     */
    public static String FORMAT_SHORT_POINT = "yyyy.MM.dd";

    /**
     * 英文最简写（默认）如：20101201
     */

    public static String FORMAT_MORE_SHORT = "yyyyMMdd";

    /**
     * 英文全称 如：2010-12-01 23:15:06
     */

    public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

    /**
     * 英文全称 如：2010-12-01 23:15
     */

    public static String FORMAT_CAR_DATE = "yyyy-MM-dd HH:mm";

    /**
     * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
     */

    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";

    /**
     * 中文简写 如：2010年12月01日
     */

    public static String FORMAT_SHORT_CN = "yyyy年MM月dd";

    /**
     * 中文全称 如：2010年12月01日 23时15分06秒
     */

    public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";

    /**
     * 精确到毫秒的完整中文时间 yyyy年MM月dd日 HH时mm分ss秒SSS毫秒
     */

    public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

    /**
     * 精确到秒的完整中文最简时间 yyyyMMddHHmmss
     */
    public static String FORMAT_FULL_SIMPLE = "yyyyMMddHHmmss";

    /**
     * 精确到秒的完整中文最简时间 HHmmss 如：100101
     */
    public static String FORMAT_TIME_FULL = "HHmmss";

    /**
     * 精确到毫秒的完整中文最简时间 如：20150304230516221
     */
    public static String FORMAT_TIME_FULL_MILLI = "yyyyMMddHHmmssSSS";

    /**
     * 日期格式正则表达式
     */
    public static String DATA_PATTERN = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";

    /**
     * 短格式日期变长格式日期附加字符串，用于补充开始查询时间
     */
    public static String ADDTIONAL_STR_BEGAIN = "2000-01-01 00:00:00";

    /**
     * 短格式日期变长格式日期附加字符串，用于补充结束查询时间
     */
    public static String ADDTIONAL_STR_END = "2000-01-01 23:59:59";

    /**
     * 获得默认的 date pattern
     */

    public static String getDatePattern() {
        return FORMAT_LONG;

    }

    /**
     * 获得默认的 date pattern
     */

    public static String getCarDatePattern() {
        return FORMAT_CAR_DATE;

    }


    /**
     * 根据预设格式返回当前日期
     *
     * @return
     */
    public static String getNow() {
        return format(new Date());

    }

    /**
     * 根据用户格式返回当前日期
     *
     * @param format
     * @return
     */
    public static String getNow(String format) {
        return format(new Date(), format);

    }

    /**
     * 使用预设格式格式化日期
     *
     * @param date
     * @return
     */

    public static String format(Date date) {

        return format(date, getDatePattern());

    }

    /**
     * 使用预设格式格式化日期
     *
     * @param date
     * @return
     */

    public static String carDateFormat(Date date) {

        return format(date, getCarDatePattern());

    }

    /**
     * 使用用户格式格式化日期
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return
     */

    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return (returnValue);
    }

    /**
     * 按指定格式将字符串转换为日期
     *
     * @param dateStr 日期串
     * @param pattern 格式
     * @return 日期
     */
    public static Date str2Date(String dateStr, String pattern) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        if (null == pattern) {
            pattern = FORMAT_SHORT;
        }
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(pattern);
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 在日期上增加天数
     *
     * @param date 日期
     * @param n    要增加的天数
     * @return
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加天数
     *
     * @param date 日期
     * @param n    要增加的小时数
     * @return
     */
    public static Date addHour(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, n);
        return cal.getTime();
    }

    /**
     * 根据时间获取前几个月的当月开始时间
     * @param date 时间
     * @param beforMouth 前几个月
     * @return 前几个月的当月开始时间
     */
    public static Date getMouthByParam(Date date, int beforMouth){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int year = c.get(1);
        int mouth = c.get(2) - beforMouth;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,mouth,1);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Date(calendar.getTimeInMillis());
    }

    /**
     * 根据时间获取前几个月的当月结束时间
     * @param date 时间
     * @param beforMouth 前几个月
     * @return 前几个月的当月结束时间
     */
    public static Date getEndMouthByParam(Date date, int beforMouth){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int year = c.get(1);
        int mouth = c.get(2) + 1 - beforMouth;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,mouth,1);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Date(calendar.getTimeInMillis() - 1);
    }

    /**
     * 获取几天前的开始时间
     * @param date 时间
     * @param beforDay 几天前
     * @return 当天的开始时间
     */
    public static Date getBeforDayByParam(Date date, int beforDay){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, - beforDay);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
}
