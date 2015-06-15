package com.oba.web.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * 日期工具类
 * 
 * @author MaChao
 * 
 */
public class DateUtil {



	private static GregorianCalendar initCalendar(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("argument date must be not null");
		}
		GregorianCalendar gc = new GregorianCalendar(Locale.CHINA);
		gc.setLenient(true);
		gc.setFirstDayOfWeek(Calendar.MONDAY);
		gc.clear();
		gc.setTime(date);
		return gc;
	}

	/**
	 * 返回传入日期的后一天
	 * 
	 * @param Date
	 *            date
	 * @return Date
	 * @author MaChao
	 */
	public static Date getNextDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		long tomorrow = gc.getTimeInMillis() + 1 * 60 * 60 * 24 * 1000;
		gc.setTimeInMillis(tomorrow);
		return gc.getTime();
	}

	/**
	 * 返回传入日期的前一天
	 * 
	 * @param Date
	 *            date
	 * @return Date
	 * @author MaChao
	 */
	public static Date getLastDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		long yestarday = gc.getTimeInMillis() - 1 * 60 * 60 * 24 * 1000;
		gc.setTimeInMillis(yestarday);
		return gc.getTime();
	}

	/**
	 * 获得日期所在月的最后一天
	 * 
	 * @param String
	 *            dateStr(yyyy-MM-dd)
	 * @return String(yyyy-MM-dd)
	 * @throws ParseException
	 * @author MaChao
	 */
	public static String getLastMonthDay(String dateStr) throws ParseException {
		Date date = praseString2Date(dateStr);
		Date lastMonthDay = getLastMonthDay(date);
		return formatDate2ShortString(lastMonthDay);
	}

	/**
	 * 将Date格式化为短型String
	 * 
	 * @param Date
	 *            date
	 * @return String(yyyy-MM-dd)
	 * @author MaChao
	 */
	public static String formatDate2ShortString(Date date) {
		initCalendar(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		return dateStr;
	}
	
	/**
	 * 将Date格式化为短型String
	 * 
	 * @param Date
	 *            date
	 * @return String(yyyy-MM-dd)
	 * @author MaChao
	 */
	public static String formatDate2ShortStringNoG(Date date) {
		initCalendar(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateStr = sdf.format(date);
		return dateStr;
	}

	/**
	 * 将短日期格式的String转化为Date类型
	 * 
	 * @param String
	 *            dateStr(yyyy-MM-dd)
	 * @return Date
	 * @throws ParseException
	 * @author MaChao
	 */
	public static Date praseString2Date(String dateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date) sdf.parse(dateStr);
		return date;
	}

	/**
	 * 将Date格式化为长型String
	 * @param date
	 * @return
	 * @author baiys
	 */
	public static String formatDate2LongString(Date date) {
		initCalendar(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(date);
		return dateStr;
	}

	/**
	 * 将长日期格式的String转化为Date类型
	 * 
	 * @param String
	 *            dateStr(yyyy-MM-dd HH:mm:ss)
	 * @return Date
	 * @throws ParseException
	 * @author MaChao
	 */
	public static Date praseString2LongDate(String dateStr)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = (Date) sdf.parse(dateStr);
		return date;
	}

	/**
	 * 取得日期所在周的第一天
	 * 
	 * @param Date
	 *            date
	 * @return Date
	 */
	public static Date getFirstWeekDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		gc.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return gc.getTime();
	}

	/**
	 * 取得日期所在周的最后一天
	 * 
	 * @param Date
	 *            date
	 * @return Date
	 */
	public static Date getLastWeekDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		gc.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return gc.getTime();
	}

	/**
	 * 取得日期所在月的第一天
	 * 
	 * @param Date
	 *            date
	 * @return Date
	 */
	public static Date getFirstMonthDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		int dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		gc.add(Calendar.DAY_OF_MONTH, 1 - dayOfMonth);
		return gc.getTime();
	}

	/**
	 * 取得日期所在月的最后一天
	 * 
	 * @param Date
	 *            date
	 * @return Date
	 */
	public static Date getLastMonthDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		int dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		int maxDaysOfMonth = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
		gc.add(Calendar.DAY_OF_MONTH, maxDaysOfMonth - dayOfMonth);
		return gc.getTime();
	}

	/**
	 * 取得日期所在旬的最后一天
	 * 
	 * @param Date
	 *            date
	 * @return Date
	 */
	public static Date getFirstTenDaysDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		int dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		if (dayOfMonth <= 10) {
			gc.set(Calendar.DAY_OF_MONTH, 1);
		} else if (dayOfMonth > 20) {
			gc.set(Calendar.DAY_OF_MONTH, 21);
		} else {
			gc.set(Calendar.DAY_OF_MONTH, 11);
		}
		return gc.getTime();
	}

	/**
	 * 取得日期所在旬的最后一天
	 * 
	 * @param Date
	 *            date
	 * @return Date
	 */
	public static Date getLastTenDaysDay(Date date) {
		GregorianCalendar gc=initCalendar(date);
		int dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		if (dayOfMonth <= 10) {
			gc.set(Calendar.DAY_OF_MONTH, 10);
		} else if (dayOfMonth > 20) {
			gc.set(Calendar.DAY_OF_MONTH, gc
					.getActualMaximum(Calendar.DAY_OF_MONTH));
		} else {
			gc.set(Calendar.DAY_OF_MONTH, 19);
		}
		return gc.getTime();
	}

	public static String getStringByTimestamp(Timestamp t){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式，不显示毫秒
		String str = df.format(t);
		return str;
	}
	public   static  String  getAgoTime (String oneHoursAgoTime) throws Exception {
		Date mydate = praseString2LongDate(oneHoursAgoTime);
		mydate.setHours(mydate.getHours() -Integer.parseInt(InitConfig.AUTO_TIME_AGO));
        oneHoursAgoTime =  new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(mydate.getTime());
        return  oneHoursAgoTime;
    }
	public   static  String  getAfterTime (String oneHoursAgoTime) throws Exception {
		if(Integer.parseInt(oneHoursAgoTime.substring(11, 13))>=23){
			return oneHoursAgoTime;
		}else{
			Date mydate = praseString2LongDate(oneHoursAgoTime);
			mydate.setHours(mydate.getHours() +Integer.parseInt(InitConfig.AUTO_TIME_AFTER));
	        oneHoursAgoTime =  new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(mydate.getTime());
	        return  oneHoursAgoTime;	
		}
    }
	public static int getDay(String mydate) throws Exception {
		  Date date = praseString2LongDate(mydate);
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  int num = 0 ;
		  switch (cal.get(Calendar.DAY_OF_WEEK)) {
			case 1:
				num =7;
				break;
			case 2:
				num =1;
				break;
			case 3:
				num =2;
				break;
			case 4:
				num =3;
				break;
			case 5:
				num =4;
				break;
			case 6:
				num =5;
				break;
			case 7:
				num =6;
				break;
			default:
				break;
			}
		  return num;
	}
	public static Date toCurrentDate (String day,String time,String second) throws ParseException{
		 Calendar now=Calendar.getInstance(); 
		 if(day.equals("明天")){
		     now.set(Calendar.DATE,now.get(Calendar.DATE)+1);  
		 }else if(day.equals("后天")){
			 now.set(Calendar.DATE,now.get(Calendar.DATE)+2); 
		 }else if(day.equals("大后天")){
			 now.set(Calendar.DATE,now.get(Calendar.DATE)+3); 
		 }else{
			 now.set(Calendar.DATE,now.get(Calendar.DATE)+4); 
		 }
		 int year = now.get(Calendar.YEAR);
		 int month = now.get(Calendar.MONTH)+ 1;
		 int date = now.get(Calendar.DATE);
		 String day_time = year+"-"+month+"-"+date+" "+time+":"+second+":00";
		 return praseString2LongDate(day_time);		 
	}
   public static Map<String,Object> getDateList(){
	   Map<String,Object> modelMap = new HashMap<String,Object> (); 
		List<String> dayList = new ArrayList<String>();
		Calendar ca = Calendar.getInstance();
		int hour = ca.get(Calendar.HOUR_OF_DAY);// 获取小时
		if (hour >= Integer.parseInt(InitConfig.AUTO_HOUR_MIN) && hour < Integer.parseInt(InitConfig.AUTO_HOUR_MAX)) {
			dayList.add("明天");
			dayList.add("后天");
		}else{
			dayList.add("后天");
		}
		Calendar now = Calendar.getInstance();
		now.set(Calendar.DATE, now.get(Calendar.DATE) + 3);
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DATE);
		dayList.add(month + "月" + day+"号");
		now = Calendar.getInstance();
		now.set(Calendar.DATE, now.get(Calendar.DATE) + 4);
	    month = now.get(Calendar.MONTH)+1;
	    day = now.get(Calendar.DATE);
		dayList.add(month + "月" + day+"号");
		if (hour <= Integer.parseInt(InitConfig.AUTO_HOUR_MIN) && hour >= Integer.parseInt(InitConfig.AUTO_HOUR_MAX)) {
			Calendar now_after = Calendar.getInstance();
			now_after.set(Calendar.DATE, now_after.get(Calendar.DATE) + 5);
			day = now_after.get(Calendar.DATE);
			dayList.add(month + "月" + day+"号");
		}
		modelMap.put("dayList", dayList);
		List<String> timeList = new ArrayList<String>();
		for (int i = Integer.parseInt(InitConfig.AUTO_HOUR_BEGIN); i < Integer.parseInt(InitConfig.AUTO_HOUR_END); i++) {
			timeList.add(i + "");
		}
		modelMap.put("timeList", timeList);
		List<String> secondList = new ArrayList<String>();
		String[] seconds = InitConfig.AUTO_HOUR_SECOND_LIST.split(",");
		for(int i=0;i<seconds.length;i++){
			secondList.add(seconds[i]);
		}
		modelMap.put("secondList", secondList);
		return modelMap;
   }
	public static void main(String[] args) {
		Date date;
		try {
			//System.out.println(getDateList());
			System.out.println(DateUtil.toCurrentDate("2月-12号", "11", "00"));
	//		System.out.println(getDay("2014-11-08 01:00:00"));
//			System.out.println(getTwoHoursAgoTime("2014-11-26 01:00:00"));
//			System.out.println(getOneHourAfterTime("2014-11-26 23:01:00"));
//			String aa = "2014-11-26 23:01:00";
//			System.out.println(aa.substring(11, 13));
			//System.out.println(getStringByTimestamp(new Timestamp(System.currentTimeMillis())));
			//date = praseString2Date("2009-10-31");
			////System.out.println("Today = " + formatDate2ShortString(date));
			////System.out.println("Yesterday = "
			//		+ formatDate2ShortString(getLastDay(date)));
			////System.out.println("Tomorrow = "
			//		+ formatDate2ShortString(getNextDay(date)));
			////System.out.println("getFirstWeekDay = " + getFirstWeekDay(date));
			////System.out.println("getLastWeekDay = " + getLastWeekDay(date));
			////System.out.println("getFirstMonthDay = " + getFirstMonthDay(date));
			////System.out.println("getLastMonthDay = " + getLastMonthDay(date));
			////System.out.println("getFirstTenDaysDay = "
			//		+ getFirstTenDaysDay(date));
			//System.out
			//		.println("getLastTenDaysDay = " + getLastTenDaysDay(date));

			////System.out.println("getLastMonthDay = "
			//		+ getLastMonthDay("2008-2-2"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
