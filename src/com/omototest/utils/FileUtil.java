/**
 * 
 */
package com.omototest.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Atrijit
 *
 */
public class FileUtil {

	/**
	 * 
	 */
	public FileUtil() {
		// TODO Auto-generated constructor stub
	}
	public static List readFile(File file){
		List list = new ArrayList();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (in.ready()) {
				  String s = in.readLine();
				  s = s.trim();
				 // s = s.toLowerCase();
				  if(!list.contains(s)){
					  list.add(s);
				  }
				 
				}
				in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static String getFile(File file){
		StringBuffer sbfr = new StringBuffer();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (in.ready()) {
				  String s = in.readLine();
				  s = s.trim();
				 // s = s.toLowerCase();
				  sbfr.append(s);
				 
				}
				in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sbfr.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getFile(new File("C:/Mywork/Omoto/SampleJSON/npsJson")));

	}

}
