// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 27-09-2014 22:11:39
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   StrUtil.java

package com.omototest.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.omototest.constants.Constants;

public class StrUtil implements Constants {

	public StrUtil() {
	}

	public static String[] nonNull(String str[]) {
		return str != null ? str : new String[0];
	}

	public static String nonNull(String s) {
		return s != null ? s : "";
	}
	
	public static String getUniqueId() {
		UUID idOne = UUID.randomUUID();
		String temp = String.valueOf(idOne);
		if(temp.indexOf("-")>0){
			temp = temp.substring(0, temp.indexOf("-"));
		}
		return temp;
	}
	
	public static String getDateString(Date dt, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String wtf = dateFormat.format(dt);
		return wtf;
	}
	
	public static void encode(String str){
		try {
			str = URLEncoder.encode(str,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
	}

	public static Date getDate(String datestr, String format) {
		Date dt = null;
		try {
			dt = (new SimpleDateFormat(format)).parse(datestr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}
	
	public static String deSlash(String str){
		str = str.replaceAll("\\/","");
		return str;
	}
	
	public static Integer randomValue(){
		Random random = new Random();
		Integer retInt = new Integer(0);
		if(random.nextBoolean()){
			retInt = new Integer(1);
		}
		return retInt;
	}
	
	
	
	
	public static void main(String args1[]) {
		/*System.out.println(getDate("12-Jul-2015","dd-MMM-yyyy"));
		System.out.println(getDateString(new Date(),DATEFORMATSTR));*/
		/*String temp = "<p align='center'><font face='Georgia' color='#993366' size='7'><u><i><b>We would like get better, help us by giving your valuable feedback.</b></i></u></font></p>";
		encode(temp);*/
		System.out.println(randomValue());
		
	}
}
