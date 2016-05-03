/**
 * 
 */
package com.omototest.utils;

import java.security.MessageDigest;
import javaQuery.j2ee.tinyURL;

/**
 * @author Atrijit
 *
 */
public class MagicEmail {

	/**
	 * 
	 */
	public MagicEmail() {
		// TODO Auto-generated constructor stub
	}
	
	private static String encryptUrl(String email, String domain)throws Exception{
		String temp = email+"|"+domain;
		MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(temp.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        String url = "http://trunxt.asia/trunext/auth.htm?p="+sb.toString();
        return url;
	}
	
	private static String shortenUrl(String url){
		tinyURL tU = new tinyURL();
		String shortlink = tU.getTinyURL(url);
		return shortlink;
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String email = "adityapise1@gmail.com";
		String domain = "aditya.tru-next.asia";
		try {
			String cryptourl = encryptUrl(email, domain);
			String shorturl = shortenUrl(cryptourl);
			System.out.println(shorturl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
