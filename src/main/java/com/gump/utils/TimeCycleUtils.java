package com.gump.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeCycleUtils {
	
	//date转字符串:"yyyy-MM-dd HH:mm:ss"
	public static String dateToDetailString(Date date){
		String timeString = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		timeString = sdf.format(date);
		return timeString;
	}
	
	//date转字符串:"yyyy-MM-dd"
	public static String dateToSimpleString(Date date){
		String timeString = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		timeString = sdf.format(date);
		return timeString;
	}
	
	//时间字符串转date："yyyy-MM-dd HH:mm:ss"
	public static Date dateFromDetailString(String timeString){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(timeString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	//时间字符串转date："yyyy-MM-dd"
	public static Date dateFromSimpleString(String timeString){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(timeString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	
}
