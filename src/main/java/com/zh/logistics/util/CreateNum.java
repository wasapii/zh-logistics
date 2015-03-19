package com.zh.logistics.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

/**
 * 各类单据号生成方法工具
 * */
public class CreateNum {

	/**
	 * 单据号生成工具
	 * */
	public static String createInvoiceNum(String num, String head) {
		StringBuffer asnNum = new StringBuffer();
		asnNum.append(head);
		Date date = new Date();
		String footStr = new String();
		String bodyStr = FormatDateUtil.formatDateToString2(date);
		int foot = 1;
		if (num != null ) {
			String body = num.substring(head.length(), head.length() + 8);// 年月日
			if (body.equals(bodyStr)) {
				footStr = num.substring(head.length() + 8, num.length());
				foot = Integer.parseInt(footStr) + 1;
			}
		}
		footStr = addZeroUtil(foot);
		asnNum.append(bodyStr).append(footStr);
		return asnNum.toString();
	}

	/**
	 * 补零工具 限0~99999
	 * */
	public static String addZeroUtil(int num) {
		if (num % 100000 >= 10000) {// 单据末尾为5位数
			return "" + num;
		} else if (num % 100000 >= 1000) {// 单据末尾为4位数
			return "0" + num;
		} else if (num % 100000 >= 100) {// 单据末尾为3位数
			return "00" + num;
		} else if (num % 100000 >= 10) {// 单据末尾为2位数
			return "000" + num;
		} else {// 单据末尾为1位数
			return "0000" + num;
		}
	}
}
