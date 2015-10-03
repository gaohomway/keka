package com.keekan.tool;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
	
	/**
	 * 获取年月日时分秒
	 * @return
	 * @throws IOException
	 */
	public static String getDateTime() throws IOException{
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance();
		String dateTime = dateFormat.format(date);
		return dateTime;
	}
	
	public static String getYearMonthDay() throws IOException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");		//设置日期格式
		String yearMonthDay = sdf.format(new Date());						// new Date()为获取当前系统时间
		return yearMonthDay;
	}
	/**
	 * 获取年月日
	 * @return
	 * @throws IOException
	 */
	public static String getYMD() throws IOException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		//设置日期格式
		String yearMonthDay = sdf.format(new Date());						// new Date()为获取当前系统时间
		return yearMonthDay;
	}
	/**
	 * 获取时分秒
	 * @return
	 * @throws IOException
	 */
	public static String getHMS() throws IOException{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");		//设置日期格式
		String yearMonthDay = sdf.format(new Date());						// new Date()为获取当前系统时间
		return yearMonthDay;
	}
}
