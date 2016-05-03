/**
 * 
 */
package com.omototest.stubcontroller.helper;

/**
 * @author Atrijit
 *
 */
public class ForwardUtil {
public static String getForwardAddress(Long processid){
	int process = processid.intValue();
	if(process==1){
		return "tabsignup.htm";
	}else if(process==2){
		return "tabsignin.htm";
	}else if(process==3){
		return "sendcampaignjson.htm";
	}else if(process==4){
		return "submitjson.htm";
	}else if(process==7){
		return "sdkin.htm";
	}else if(process==8){
		return "sdkout.htm";
	}
	return "";
}
}
