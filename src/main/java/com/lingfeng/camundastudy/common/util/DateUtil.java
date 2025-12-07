package com.lingfeng.camundastudy.common.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 日期时间格式转换类，对 {@link Calendar} 的封装，以便于使用
 */
public class DateUtil extends org.apache.commons.lang3.time.DateUtils implements Serializable {

    /** 时区 - 默认 */
    public static final String TIME_ZONE_DEFAULT = "GMT+8";

    /** 时间格式 <p>yyyy-MM-dd HH:mm:ss.SSS</p> */
    public static final String CT_DS_S = "yyyy-MM-dd HH:mm:ss.SSS";


    /** 时间格式 <p>yyyy-MM-dd HH:mm:ss</p> */
    public static final String CT_DS = "yyyy-MM-dd HH:mm:ss";

    public static final String CT_DS_A = "yyyy-MM-dd HH-mm-ss";
    /** 时间格式 <p>yyyy/MM/dd HH:mm:ss</p> */
    public static final String CS_DS = "yyyy/MM/dd HH:mm:ss";
    /** 时间格式 <p>yyyy.MM.dd HH:mm:ss</p> */
    public static final String CD_SS = "yyyy.MM.dd HH:mm:ss";
    /** 时间格式 <p>yyyy年MM月dd日 HH时mm分ss秒</p> */
    public static final String CN_SS = "yyyy年MM月dd日 HH时mm分ss秒";
    /** 时间格式 <p>yyyyMMddHHmmss</p> */
    public static final String CP_DS = "yyyyMMddHHmmss";

    /** 时间格式 <p>HH:mm:ss</p> */
    public static final String CT_TS = "HH:mm:ss";
    /** 时间格式 <p>HHmmss</p> */
    public static final String CP_TS = "HHmmss";
    /** 时间格式 <p>HH时mm分ss秒</p> */
    public static final String CN_TS = "HH时mm分ss秒";

    /** 时间格式 <p>yyyy-MM-dd</p> */
    public static final String CT_D = "yyyy-MM-dd";
    /** 时间格式 <p>yyyy/MM/dd</p> */
    public static final String CS_D = "yyyy/MM/dd";
    /** 时间格式 <p>yyyy.MM.dd</p> */
    public static final String CD_D = "yyyy.MM.dd";
    /** 时间格式 <p>yyyyMMdd</p> */
    public static final String CP_D = "yyyyMMdd";
    /** 时间格式 <p>yyyy年MM月dd日</p> */
    public static final String CN_D = "yyyy年MM月dd日";

    /** 时间格式 <p>yyyy-MM</p> */
    public static final String CT_M = "yyyy-MM";
    /** 时间格式 <p>yyyyMM</p> */
    public static final String CP_M = "yyyyMM";
    /** 时间格式 <p>yyyy/MM</p> */
    public static final String CS_M = "yyyy/MM";
    /** 时间格式 <p>yyyy.MM</p> */
    public static final String CD_M = "yyyy.MM";
    /** 时间格式 <p>yyyy年MM月</p> */
    public static final String CN_M = "yyyy年MM月";

    /** 时间格式 <p>yyyyMMdd'T'HHmmss'Z'</p> */
    public static final String CT_DS_Z_ISO_8601 = "yyyyMMdd'T'HHmmss'Z'";

    /** 时间格式 <p>yyyy-MM-dd'T'HH:mm:ss.SSSZ</p> */
    public static final String CT_DSS_Z_UTC = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    /** 时间格式 <p>yyyy-MM-dd HH:mm</p> */
    public static final String CT_MM = "yyyy-MM-dd HH:mm";
    /** 时间格式 <p>yyyy/MM/dd HH:mm</p> */
    public static final String CS_MM = "yyyy/MM/dd HH:mm";
    /** 时间格式 <p>yyyy.MM.dd HH:mm</p> */
    public static final String CD_MM = "yyyy.MM.dd HH:mm";
    /** 时间格式 <p>yyyyMMddHHmm</p> */
    public static final String CP_MM = "yyyyMMddHHmm";
    /** 时间格式 <p>yyyy年MM月dd日 HH时mm分</p> */
    public static final String CN_MM = "yyyy年MM月dd日 HH时mm分";

    /** 时间解析模式 */
    private static final String[] TIME_PARSE_PATTERNS = {"HH:mm:ss", "HHmmss", "HH时mm分ss秒"};
    /** 日期解析模式 */
    private static final String[] DATE_PARSE_PATTERNS = {"yyyy-MM-dd", "yyyy/MM/dd", "yyyy.MM.dd", "yyyyMMdd", "yyyy年MM月dd日", "yyyy-MM", "yyyyMM", "yyyy/MM", "yyyy.MM", "yyyy年MM月"};
    /** 日期时间解析模式 */
    private static final String[] DATE_TIME_PARSE_PATTERNS = {"yyyy-MM-dd HH:mm:ss.SSS", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss", "yyyy.MM.dd HH:mm:ss", "yyyy年MM月dd日 HH时mm分ss秒", "yyyyMMddHHmmss", "HH:mm:ss", "HHmmss", "HH时mm分ss秒", "yyyy-MM-dd", "yyyy/MM/dd", "yyyy.MM.dd", "yyyyMMdd", "yyyy年MM月dd日", "yyyy-MM", "yyyyMM", "yyyy/MM", "yyyy.MM", "yyyy年MM月", "yyyyMMdd'T'HHmmss'Z'", "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd HH:mm", "yyyy/MM/dd HH:mm", "yyyy.MM.dd HH:mm", "yyyyMMddHHmm", "yyyy年MM月dd日 HH时mm分"};

    /** 年  <p>可以通过DateTime.now().get(DateTime.YEAR_FIELD)来获取当前时间的年</p> */
    public static final int YEAR_FIELD = Calendar.YEAR;
    /** 月 <p>可以通过DateTime.now().get(DateTime.MONTH_FIELD)来获取当前时间的月</p> */
    public static final int MONTH_FIELD = Calendar.MONTH;
    /** 日  <p>可以通过DateTime.now().get(DateTime.DAY_FIELD)来获取当前时间的日</p> */
    public static final int DAY_FIELD = Calendar.DATE;
    /** 小时 <p>可以通过DateTime.now().get(DateTime.HOUR_FIELD)来获取当前时间的小时</p> */
    public static final int HOUR_FIELD = Calendar.HOUR_OF_DAY;
    /** 分钟 <p>可以通过DateTime.now().get(DateTime.MINUTE_FIELD)来获取当前时间的分钟</p> */
    public static final int MINUTE_FIELD = Calendar.MINUTE;
    /** 秒 <p>可以通过DateTime.now().get(DateTime.SECOND_FIELD)来获取当前时间的秒</p> */
    public static final int SECOND_FIELD = Calendar.SECOND;
    /** 毫秒 <p>可以通过DateTime.now().get(DateTime.MILLISECOND_FIELD)来获取当前时间的毫秒</p> */
    public static final int MILLISECOND_FIELD = Calendar.MILLISECOND;

    /** 日历类 */
    private final Calendar calendar;

    /**
     * 获取一个 {@link DateUtil}，此 {@link DateUtil} 尚未初始化
     * <p>
     * 要获取当前系统时间,请用 {@link DateUtil} 的 now() 方法;
     * </p>
     */
    private DateUtil() {
        this.calendar = null;
    }

    /**
     * 设置时间
     * <p>
     * 可以传入一个 {@link Calendar} 对象，返回 {@link DateUtil} 对象
     * </p>
     *
     * @param calendar 日历对象
     */
    public DateUtil(Calendar calendar) {
        this.calendar = calendar;
    }

    /**
     * 设置时间
     * <p>
     * 可以传入一个 {@link Date} 对象，返回 {@link DateUtil} 对象
     * </p>
     *
     * @param date 时间对象
     */
    public DateUtil(Date date) {
        if (null == date) {
            this.calendar = null;
            return;
        }
        this.calendar = Calendar.getInstance();
        this.calendar.setTime(date);
    }

    /**
     * 用毫秒来设置时间, 时间的基数是 1970-1-1 00:00:00.000;
     * <p>
     * 比如, new DateTime(1000) 则表示 1970-1-1 00:00:01.000; <br>
     * 用负数表示基础时间以前的时间
     * </p>
     *
     * @param milliseconds 毫秒
     */
    public DateUtil(Long milliseconds) {
        if (null == milliseconds) {
            this.calendar = null;
            return;
        }
        this.calendar = Calendar.getInstance();
        this.calendar.setTimeInMillis(milliseconds);
    }

    /**
     * 获取当前系统时间
     *
     * @return {@link DateUtil} 当前系统时间
     */
    public static DateUtil now() {
        Calendar calendar = Calendar.getInstance();
        return new DateUtil(calendar);
    }

    /**
     * 可以传入一个 {@link Date} 对象，返回 {@link DateUtil} 对象
     *
     * @return {@link DateUtil}
     */
    public static DateUtil now(Date date) {
        return new DateUtil(date);
    }

    /**
     * 可以传入一个 {@link ZonedDateTime} 对象，返回 {@link DateUtil} 对象
     *
     * @return {@link DateUtil}
     */
    public static DateUtil now(ZonedDateTime date) {
        if (null == date) {
            return new DateUtil();
        }
        return new DateUtil(Date.from(date.toInstant()));
    }

    /**
     * 可以传入一个 {@link LocalDateTime} 对象，返回 {@link DateUtil} 对象
     *
     * @return {@link DateUtil}
     */
    public static DateUtil now(LocalDateTime date) {
        if (null == date) {
            return new DateUtil();
        }
        return DateUtil.now(date.atZone(ZoneId.systemDefault()));
    }

    /**
     * 用毫秒来设置时间, 时间的基数是 1970-1-1 00:00:00.000;
     * <p>
     * 比如, new DateTime(1000) 则表示 1970-1-1 00:00:01.000; <br>
     * 用负数表示基础时间以前的时间
     * </p>
     *
     * @param milliseconds 毫秒
     */
    public static DateUtil now(Long milliseconds) {
        return new DateUtil(milliseconds);
    }

    /**
     * 转换成 {@link Calendar} 对象
     *
     * @return {@link Calendar}
     */
    public Calendar toCalendar() {
        return this.calendar;
    }

    /**
     * 转换成 {@link java.sql.Date} (yyyy-MM-dd)日期
     *
     * @return {@link java.sql.Date}
     */
    public java.sql.Date toSqlDate() {
        if (null == this.calendar) {
            return null;
        }
        return new java.sql.Date(this.calendar.getTimeInMillis());
    }

    /**
     * 转换为 {@link java.sql.Time} (hh:mm:ss)时间
     *
     * @return {@link java.sql.Time}
     */
    public java.sql.Time toSqlTime() {
        if (null == this.calendar) {
            return null;
        }
        return new java.sql.Time(this.calendar.getTimeInMillis());
    }

    /**
     * 转换为 {@link java.sql.Timestamp} 时间戳
     *
     * @return {@link java.sql.Timestamp}
     */
    public java.sql.Timestamp toSqlTimestamp() {
        if (null == this.calendar) {
            return null;
        }
        return new java.sql.Timestamp(this.calendar.getTimeInMillis());
    }

    /**
     * 转换为 {@link Date} 对象
     *
     * @return Date时间
     */
    public Date toDate() {
        if (null == this.calendar) {
            return null;
        }
        return this.calendar.getTime();
    }

    /**
     * 转换为 yyyy-MM-dd 格式字符串
     *
     * @return 日期字符串
     */
    public String toDateStr() {
        return toString(DateUtil.CT_D);
    }

    /**
     * 转换为 yyyy年MM月dd日 格式字符串
     *
     * @return 日期字符串
     */
    public String toDateCNStr() {
        return toString(DateUtil.CN_D);
    }

    /**
     * 转换为 HH:mm:ss 格式字符串
     *
     * @return HH:mm:ss 格式时间字符串
     */
    public String toTimeStr() {
        return toString(DateUtil.CT_TS);
    }

    /**
     * 转换为 yyyy-MM-dd HH:mm:ss 格式字符串
     *
     * @return yyyy-MM-dd HH:mm:ss 格式字符串
     */
    public String toDateTimeStr() {
        return toString(DateUtil.CD_SS);
    }

    /**
     * 转换为时间戳
     */
    public long toTimeStamp() {
        return this.calendar.getTimeInMillis() / 1000;
    }

    /**
     * 转换为 yyyy-MM-dd HH:mm:ss.SSS 格式字符串
     *
     * @return yyyy-MM-dd HH:mm:ss.SSS 格式字符串
     */

    @Override
    public String toString() {
        return toString(DateUtil.CT_DS_S);
    }

    /**
     * 使用日期转换 pattern
     * <p>
     * pattern 的用法参见 {@link SimpleDateFormat}
     * </p>
     *
     * @param pattern 日期解析规则
     * @return 按规则转换后的日期时间字符串
     */
    public String toString(String pattern) {
        if (null == this.calendar) {
            return null;
        }
        SimpleDateFormat fmt = (SimpleDateFormat) java.text.DateFormat.getDateInstance();
        fmt.applyPattern(pattern);
        return fmt.format(this.calendar.getTime());
    }

    /**
     * 解析时间字符串（HH:mm:ss等，不包含日期），返回 {@link DateUtil} 对象
     *
     * @param timeStr 字符串格式时间
     * @return {@link DateUtil}
     */
    public static DateUtil parseTime(String timeStr) throws ParseException {
        return new DateUtil(DateUtil.parseDate(timeStr, DateUtil.TIME_PARSE_PATTERNS));
    }

    /**
     * 解析日期字符串（yyyy-MM-dd等，不包含时间），返回 {@link DateUtil} 对象
     *
     * @param dateStr 字符串格式日期
     * @return {@link DateUtil}
     */
    public static DateUtil parseDate(String dateStr) throws ParseException {
        return new DateUtil(DateUtil.parseDate(dateStr, DateUtil.DATE_PARSE_PATTERNS));
    }

    /**
     * 通用日期时间字符串解析方法，返回 {@link DateUtil} 对象 <br>
     * 在时间与日期不明确的情况下使用，优先解析 yyyy-MM-dd HH:mm:ss.SSS 等既包含日期也包含时间的格式
     *
     * @param dateStr 字符串格式日期时间
     * @return {@link DateUtil}
     */
    public static DateUtil parse(String dateStr) throws ParseException {
        return new DateUtil(DateUtil.parseDate(dateStr, DateUtil.DATE_TIME_PARSE_PATTERNS));
    }

    /**
     * 用指定的日期解析规则解析字符串，返回 {@link DateUtil} 对象
     *
     * @param dateStr 字符串格式日期时间
     * @param format  日期解析规则
     * @return {@link DateUtil}
     * @see SimpleDateFormat
     */
    public static DateUtil parse(String dateStr, String format) throws ParseException {
        SimpleDateFormat fmt = (SimpleDateFormat) java.text.DateFormat.getDateInstance();
        fmt.applyPattern(format);
        return new DateUtil(fmt.parse(dateStr));
    }

    /**
     * 获取 {@link DateUtil} 所表示时间的某个度量的值
     *
     * @param field int 取值为:<br>
     *              DateTime.YEAR_FIELD -- 返回年份<br>
     *              DateTime.MONTH_FIELD -- 返回月份,一月份返回1,二月份返回2,依次类推<br>
     *              DateTime.DAY_FIELD --返回当前的天(本月中的)<br>
     *              DateTime.HOUR_FIELD -- 返回小时数(本天中的),24小时制<br>
     *              DateTime.MINUTE_FIELD -- 返回分钟数(本小时中的)<br>
     *              DateTime.SECOND_FIELD -- 返回秒数(本分钟中的)<br>
     *              DateTime.MILLISECOND_FIELD -- 返回毫秒数(本秒中的)
     * @return int field对应的值
     */
    public int get(int field) {
        if (null == this.calendar) {
            throw new RuntimeException("this datetime has not been initialized!");
        }
        // 月份需要 +1 (月份从0开始)
        if (DateUtil.MONTH_FIELD == field) {
            return this.calendar.get(field) + 1;
        } else {
            return this.calendar.get(field);
        }
    }

    /**
     * 返回 {@link DateUtil} 所表示时间的持续时间（以毫秒（Millis）为单位）
     *
     * @return long 毫秒（Millis）
     */
    public long getTimeInMillis() {
        if (null == this.calendar) {
            throw new RuntimeException("this datetime has not been initialized!");
        }
        return this.calendar.getTimeInMillis();
    }

    /**
     * 将 {@link DateUtil} 所表示时间的持续时间转换为秒（Seconds）。
     * 从更细到更粗粒度的转换会截断，因此就失去了精度。 例如，将 999 毫秒转换为秒，结果为 0
     *
     * @return long 秒（Seconds）
     */
    public long getTimeInSeconds() {
        long millis = this.getTimeInMillis();
        return TimeUnit.MILLISECONDS.toSeconds(millis);
    }

    /**
     * 将 {@link DateUtil} 所表示时间的持续时间转换为分钟（Minutes）。
     * 从更细到更粗粒度的转换会截断，因此就失去了精度。 例如，将 999 毫秒转换为秒，结果为 0
     *
     * @return long 分钟（Minutes）
     */
    public long getTimeInMinutes() {
        long millis = this.getTimeInMillis();
        return TimeUnit.MILLISECONDS.toMinutes(millis);
    }

    /**
     * 将 {@link DateUtil} 所表示时间的持续时间转换为小时（Hours）。
     * 从更细到更粗粒度的转换会截断，因此就失去了精度。 例如，将 999 毫秒转换为秒，结果为 0
     *
     * @return long 小时（Hours）
     */
    public long getTimeInHours() {
        long millis = this.getTimeInMillis();
        return TimeUnit.MILLISECONDS.toHours(millis);
    }

    /**
     * 将 {@link DateUtil} 所表示时间的持续时间转换为天数（Days）。
     * 从更细到更粗粒度的转换会截断，因此就失去了精度。 例如，将 999 毫秒转换为秒，结果为 0
     *
     * @return long 天数（Days）
     */
    public long getTimeInDays() {
        long millis = this.getTimeInMillis();
        return TimeUnit.MILLISECONDS.toDays(millis);
    }

    /**
     * 将 {@link DateUtil} 所表示时间的持续时间转换为月数（Months），以 30 天为一个月计算。
     * 从更细到更粗粒度的转换会截断，因此就失去了精度。 例如，将 40 天转换为月，结果为 1
     *
     * @return long 月数（Months）
     */
    public long getTimeInMonths() {
        long days = this.getTimeInDays();
        return days / 30;
    }

    /**
     * 将 {@link DateUtil} 所表示时间的持续时间转换为年数（Years），以 12 个月为一年计算。
     * 从更细到更粗粒度的转换会截断，因此就失去了精度。 例如，将 13 月转换为年，结果为 1
     *
     * @return long 年数（Years）
     */
    public long getTimeInYears() {
        long months = this.getTimeInMonths();
        return months / 12;
    }

    /**
     * 将 {@link DateUtil} 所表示时间的持续时间转换为指定单位的值。
     * 从更细到更粗粒度的转换会截断，因此就失去了精度。 例如，将 999 毫秒转换为秒，结果为 0
     *
     * @param field int 取值为: <br>
     *              DateTime.YEAR_FIELD -- 年份 <br>
     *              DateTime.MONTH_FIELD -- 月份 <br>
     *              DateTime.DAY_FIELD -- 天数 <br>
     *              DateTime.HOUR_FIELD -- 小时数 <br>
     *              DateTime.MINUTE_FIELD -- 分钟数 <br>
     *              DateTime.SECOND_FIELD -- 秒数 <br>
     *              DateTime.MILLISECOND_FIELD -- 毫秒数
     * @return long value
     */
    public long getTime(int field) {
        long millis = this.getTimeInMillis();
        switch (field) {
            case YEAR_FIELD:
                return this.getTimeInYears();
            case MONTH_FIELD:
                return this.getTimeInMonths();
            case DAY_FIELD:
                return this.getTimeInDays();
            case HOUR_FIELD:
                return this.getTimeInHours();
            case MINUTE_FIELD:
                return this.getTimeInMinutes();
            case SECOND_FIELD:
                return this.getTimeInSeconds();
            case MILLISECOND_FIELD:
                return this.getTimeInMillis();
            default:
                return 0;
        }
    }

    /**
     * 转换时间，表示一天的开始，eg：2023-04-13 00:00:00.000
     */
    public DateUtil convertDailyStartTime() {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return this;
    }

    /**
     * 转换时间，表示一天的结束，eg：2023-04-13 23:59:59.999
     */
    public DateUtil convertDailyEndTime() {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return this;
    }

    /**
     * 转换时间，表示一个月的开始，eg：2023-04-01 00:00:00.000
     */
    public DateUtil convertMonthStartTime() {
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return this.convertDailyStartTime();
    }

    /**
     * 转换时间，表示一个月的结束，eg：2023-04-30 23:59:59.999
     */
    public DateUtil convertMonthEndTime() {
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return this.convertDailyEndTime();
    }

    /**
     * 转换时间，表示一年的开始，eg：2023-01-01 00:00:00.000
     */
    public DateUtil convertYearStartTime() {
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        return this.convertDailyStartTime();
    }

    /**
     * 转换时间，表示一年的结束，eg：2023-12-31 23:59:59.999
     */
    public DateUtil convertYearEndTime() {
        int year = calendar.get(Calendar.YEAR);
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        return this.convertDailyEndTime();
    }

    /**
     * 设置field字段的值
     *
     * @param field int 取值为: <br>
     *              DateTime.YEAR_FIELD -- 年份 <br>
     *              DateTime.MONTH_FIELD -- 月份,一月份从1开始 <br>
     *              DateTime.DAY_FIELD -- 当前的天(本月中的) <br>
     *              DateTime.HOUR_FIELD -- 小时数(本天中的),24小时制 <br>
     *              DateTime.MINUTE_FIELD -- 分钟数(本小时中的) <br>
     *              DateTime.SECOND_FIELD -- 秒数(本分钟中的) <br>
     *              DateTime.MILLISECOND_FIELD -- 毫秒数(本秒中的)
     * @param value 值
     */
    public DateUtil set(int field, int value) {
        if (null == this.calendar) {
            throw new RuntimeException("this datetime has not been initialized!");
        }
        // 月份需要 -1 ( 月份从 0 开始 )
        if (DateUtil.MONTH_FIELD == field) {
            this.calendar.set(field, value - 1);
        } else {
            this.calendar.set(field, value);
        }
        return this;
    }

    /**
     * 设置 {@link DateUtil} 日期的年/月/日
     *
     * @param year  年
     * @param month 月
     * @param day   日
     */
    public DateUtil set(int year, int month, int day) {
        if (null == this.calendar) {
            throw new RuntimeException("this datetime has not been initialized!");
        }
        set(DateUtil.YEAR_FIELD, year);
        set(DateUtil.MONTH_FIELD, month);
        set(DateUtil.DAY_FIELD, day);
        return this;
    }

    /**
     * 设置 {@link DateUtil} 日期的年/月/日/小时
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @param hour  小时
     */
    public DateUtil set(int year, int month, int day, int hour) {
        if (null == this.calendar) {
            throw new RuntimeException("this datetime has not been initialized!");
        }
        set(year, month, day);
        set(DateUtil.HOUR_FIELD, hour);
        return this;
    }

    /**
     * 设置 {@link DateUtil} 日期的年/月/日/小时/分钟
     *
     * @param year   年
     * @param month  月
     * @param day    日
     * @param hour   小时
     * @param minute 分钟
     */
    public DateUtil set(int year, int month, int day, int hour, int minute) {
        if (null == this.calendar) {
            throw new RuntimeException("this datetime has not been initialized!");
        }
        set(year, month, day, hour);
        set(DateUtil.MINUTE_FIELD, minute);
        return this;
    }

    /**
     * 设置 {@link DateUtil} 日期的年/月/日/小时/分钟/秒
     *
     * @param year   年
     * @param month  月
     * @param day    日
     * @param hour   小时
     * @param minute 分钟
     * @param second 秒
     */
    public DateUtil set(int year, int month, int day, int hour, int minute, int second) {
        if (null == this.calendar) {
            throw new RuntimeException("this datetime has not been initialized!");
        }
        set(year, month, day, hour, minute);
        set(DateUtil.SECOND_FIELD, second);
        return this;
    }

    /**
     * 设置 {@link DateUtil} 日期的年/月/日/小时/分钟/秒/毫秒
     *
     * @param year        年
     * @param month       月
     * @param day         日
     * @param hour        小时
     * @param minute      分钟
     * @param second      秒
     * @param milliSecond 毫秒
     */
    public DateUtil set(int year, int month, int day, int hour, int minute, int second, int milliSecond) {
        if (null == this.calendar) {
            throw new RuntimeException("this datetime has not been initialized!");
        }
        set(year, month, day, hour, minute, second);
        set(DateUtil.MILLISECOND_FIELD, milliSecond);
        return this;
    }

    /**
     * 对field值进行相加
     * <p>
     * add() 的功能非常强大，add 可以对 DateTime 的字段进行计算。<br>
     * 如果需要减去值，那么使用负数值就可以了，如 add(field, -value)。<br>
     * 或者调用DateTime.reduce(int,int)进行日期相减
     * </p>
     *
     * @param field  int 取值为:<br>   DateTime.YEAR_FIELD -- 年份<br>
     *               DateTime.MONTH_FIELD -- 月份,一月份从1开始<br>
     *               DateTime.DAY_FIELD -- 当前的天(本月中的)<br>
     *               DateTime.HOUR_FIELD -- 小时数(本天中的),24小时制<br>
     *               DateTime.MINUTE_FIELD -- 分钟数(本小时中的)<br>
     *               DateTime.SECOND_FIELD -- 秒数(本分钟中的)<br>
     *               DateTime.MILLISECOND_FIELD -- 毫秒数(本秒中的)
     * @param amount 数量(如果数量小于0则为相减)
     */
    public DateUtil add(int field, int amount) {
        if (null == this.calendar) {
            throw new RuntimeException("this datetime has not been initialized!");
        }
        this.calendar.add(field, amount);
        return this;
    }

    /**
     * 对field值进行相减
     * <p>
     * 对 add() 的功能进行封装，add 可以对 {@link Calendar} 的字段进行计算。<br>
     * 如果需要减去值，那么使用负数值就可以了，如 add(field, -value)。<br>
     * 详细用法参见 Calendar.add(int,int)
     * </p>
     *
     * @param field  int 取值为:<br>   DateTime.YEAR_FIELD -- 年份<br>
     *               DateTime.MONTH_FIELD -- 月份,一月份从1开始<br>
     *               DateTime.DAY_FIELD -- 当前的天(本月中的)<br>
     *               DateTime.HOUR_FIELD -- 小时数(本天中的),24小时制<br>
     *               DateTime.MINUTE_FIELD -- 分钟数(本小时中的)<br>
     *               DateTime.SECOND_FIELD -- 秒数(本分钟中的)<br>
     *               DateTime.MILLISECOND_FIELD -- 毫秒数(本秒中的)
     * @param amount 数量(如果数量小于0则为相加)
     */
    public DateUtil reduce(int field, int amount) {
        if (null == this.calendar) {
            throw new RuntimeException("this datetime has not been initialized!");
        }
        this.calendar.add(field, -amount);
        return this;
    }

    /**
     * 判断此 {@link DateUtil} 表示的时间是否在指定 Object 表示的时间之后，返回判断结果。
     * <p>
     * 此方法等效于：compareTo(when) > 0 <br>
     * 当且仅当 when 是一个 {@link DateUtil} 实例时才返回 true。否则该方法返回 false。
     * </p>
     *
     * @param when 要比较的 Object
     * @return 如果此 DateTime 的时间在 when 表示的时间之后，则返回 true；否则返回 false。
     */
    public boolean after(Object when) {
        if (null == this.calendar) {
            throw new RuntimeException("this datetime has not been initialized!");
        }
        if (when instanceof DateUtil) {
            return this.calendar.after(((DateUtil) when).calendar);
        }
        return this.calendar.after(when);
    }

    /**
     * 判断此 {@link DateUtil} 表示的时间是否在指定 Object 表示的时间之前，返回判断结果。
     * <p>
     * 此方法等效于：compareTo(when) < 0 <br>
     * 当且仅当 when 是一个 {@link DateUtil} 实例时才返回 true。否则该方法返回 false。
     * </p>
     *
     * @param when 要比较的 Object
     * @return 如果此 {@link Calendar} 的时间在 when 表示的时间之前，则返回 true；否则返回 false。
     */
    public boolean before(Object when) {
        if (null == this.calendar) {
            throw new RuntimeException("this datetime has not been initialized!");
        }
        if (when instanceof DateUtil) {
            return this.calendar.before(((DateUtil) when).calendar);
        }
        return this.calendar.before(when);
    }

    /**
     * 创建并返回此对象的一个副本
     *
     * @return 日期时间对象
     */
    @Override
    public Object clone() {
        if (null == this.calendar) {
            throw new RuntimeException("this datetime has not been initialized!");
        }
        return new DateUtil((Calendar) this.calendar.clone());
    }

    /**
     * 返回该此日历的哈希码
     *
     * @return 此对象的哈希码值。
     * @see Object
     */
    @Override
    public int hashCode() {
        if (null == this.calendar) {
            throw new RuntimeException("this datetime has not been initialized!");
        }
        return this.calendar.hashCode();
    }

    /**
     * 将此 {@link DateUtil} 与指定 Object 比较。
     *
     * @param obj - 要与之比较的对象。
     * @return 如果此对象等于 obj，则返回 true；否则返回 false。
     * @see Object
     */
    @Override
    public boolean equals(Object obj) {
        if (null == this.calendar) {
            throw new RuntimeException("this datetime has not been initialized!");
        }
        if (obj instanceof DateUtil) {
            return this.calendar.equals(((DateUtil) obj).toCalendar());
        }
        if (obj instanceof Calendar) {
            return this.calendar.equals(obj);
        }
        if (obj instanceof Date) {
            return this.calendar.getTime().equals(obj);
        }
        return false;
    }

}
