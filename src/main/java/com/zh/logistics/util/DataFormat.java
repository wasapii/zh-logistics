package com.zh.logistics.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DataFormat {

	/**
	 * 含有空格的字符串拆分并转换成数组
	 * */
	public static String[] StringFormatArray(String str){
		String [] strArray = str.split(" ");
		return strArray;
	}
	
	/**
	 * 日期格式转换
	 * return string yyyy-MM-DD
	 * */
	public static String  formatDateToString(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	/**
	 * 日期格式转换
	 * return yyyy-MM-DD hh:mm:ss
	 * */
	public static String formatTimeToString(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(date);
	}
	
	/**
	 * 日期转换格式
	 * return Date()
	 * @throws ParseException 
	 * */
	public static Date formatStringToDate(String date) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(date);
	}
	
	public static void main(String[] args) throws ParseException {
		System.err.println("========="+DataFormat.formatStringToDate("2015-02-05"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(date);
		String t= format.format(date);
		System.err.println(t);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String t2= format1.format(date);
		System.err.println(t2);
	}
}
