package com.linewell.gg.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    private static final String PATTERN_DATE = "yyyy-MM-dd";

    private static final String PATTERN_TIME = "HH:mm:ss";

    private static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";

    private static final String PATTERN_FULL = "yyyy-MM-dd HH:mm:ss.SSS";


    public static final Date parse(String pattern, String source) {
        try {
            return new SimpleDateFormat(pattern, Locale.US).parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("parse date error : ", e);
        }
    }


    public static final Date parseDateTime(String source) {
        try {
            return new SimpleDateFormat(PATTERN_DATETIME).parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("parse date error : ", e);
        }
    }


    public static final Date parseDate(String source) {
        try {
            return new SimpleDateFormat(PATTERN_DATE).parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("parse date error : ", e);
        }
    }


    public static final Date parseTime(String source) {
        try {
            return new SimpleDateFormat(PATTERN_TIME).parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("parse date error : ", e);
        }
    }


    public static final Date parseFull(String source) {
        try {
            return new SimpleDateFormat(PATTERN_FULL).parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("parse date error : ", e);
        }
    }


    public static final String format(String pattern, Date date) {
        return new SimpleDateFormat(pattern, Locale.US).format(date);
    }


    public static final String formatDateTime(Date date) {
        return new SimpleDateFormat(PATTERN_DATETIME).format(date);
    }


    public static final String formatDate(Date date) {
        return new SimpleDateFormat(PATTERN_DATE).format(date);
    }


    public static final String formatTime(Date date) {
        return new SimpleDateFormat(PATTERN_TIME).format(date);
    }


    public static final String formatFull(Date date) {
        return new SimpleDateFormat(PATTERN_FULL).format(date);
    }


    public static final String format(String outPatt, String inPatt, String source) {
        return format(outPatt, parse(inPatt, source));
    }


    public static final String getTimestamp(String pattern) {
        return format(pattern, new Date());
    }


    public static final int calDValueOfYear(Date fromDate, Date toDate) {
        Calendar sCal = Calendar.getInstance();
        Calendar eCal = Calendar.getInstance();
        sCal.setTime(fromDate);
        eCal.setTime(toDate);

        return eCal.get(Calendar.YEAR) - sCal.get(Calendar.YEAR);
    }


    public static final int calDValueOfMonth(Date fromDate, Date toDate) {
        Calendar sCal = Calendar.getInstance();
        Calendar eCal = Calendar.getInstance();
        sCal.setTime(fromDate);
        eCal.setTime(toDate);

        return 12 * (eCal.get(Calendar.YEAR) - sCal.get(Calendar.YEAR)) + (eCal.get(Calendar.MONTH) - sCal.get(Calendar.MONTH));
    }


    public static final int calDValueOfDay(Date fromDate, Date toDate) {
        return (int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24));
    }


    public static final Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }


    public static final Date getFirstDayOfWeek(Date date) {
        return getFirstDayOfWeek(date, Calendar.MONDAY);
    }


    public static final Date getLastDayOfWeek(Date date) {
        return getLastDayOfWeek(date, Calendar.MONDAY);
    }


    public static final Date getFirstDayOfWeek(Date date, int firstDayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(firstDayOfWeek);

        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }


    public static final Date getLastDayOfWeek(Date date, int firstDayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(firstDayOfWeek);

        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.DAY_OF_YEAR, 7);
        calendar.add(Calendar.MILLISECOND, -1);

        return calendar.getTime();
    }


    public static final Date[] getWeek(Date date) {
        return getWeek(date, Calendar.MONDAY);
    }


    public static final Date[] getWeek(Date date, int firstDayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(firstDayOfWeek);

        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date firstDate = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 7);
        calendar.add(Calendar.MILLISECOND, -1);
        Date lastDate = calendar.getTime();

        return new Date[]{firstDate, lastDate};
    }


    public static java.sql.Date toSQLDate(Date date) {
        return new java.sql.Date(date.getTime());
    }


    public static java.sql.Date getSQLDate() {
        return new java.sql.Date(System.currentTimeMillis());
    }


    public static java.sql.Timestamp getSQLTimestamp() {
        return new java.sql.Timestamp(System.currentTimeMillis());
    }

    public static java.sql.Timestamp getTimestamp(int day) {
        return new java.sql.Timestamp(System.currentTimeMillis() + 24 * 60 * 60 * 1000 * day);
    }


    public static Date add(Date date, int field, int increment) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(field, increment);
        return cal.getTime();
    }


    public static Date set(Date date, int field, int value) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(field, value);
        return cal.getTime();
    }


    public static Long getMillisTime() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
		/*System.out.println(DateUtil.getTimestamp("yyyyMMdd"));


		String str=DateUtil.formatDate(DateUtil.add(new Date(), Calendar.DAY_OF_YEAR, -30));
		System.out.println(str);*/
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.format(new Date(1440000660125L));
        System.out.println(Timestamp.valueOf(df.format(new Date(1440000660125L))));

    }
}