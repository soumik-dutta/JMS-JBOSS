/**
 * 
 */
package com.omototest.stubcontroller;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.google.gson.Gson;
import com.omototest.constants.Constants;
import com.omototest.jsonobjects.IncomingCampaignRequest;
import com.omototest.jsonobjects.OutgoingCampaignsJson;
import com.omototest.utils.FileUtil;
import com.omototest.utils.StrUtil;

/**
 * @author Atrijit
 *
 */
public class SendCampaignJsonController implements Controller, Constants{
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		File file  = 	new File("C:/home/omoto/samplejson/smilemerchantsnps.txt");
		String jsonString = FileUtil.getFile(file);
		Gson gson = new Gson();
		OutgoingCampaignsJson outgoingCampaignsJson = new OutgoingCampaignsJson();
		outgoingCampaignsJson.setCampaignjson(jsonString);
		outgoingCampaignsJson.setType("NPS");
		outgoingCampaignsJson.setId(new Long(17));
		List list = new ArrayList();
		list.add(outgoingCampaignsJson);
		String responseString = gson.toJson(list);
		System.out.println("Smile Merchant debug: "+responseString);
		response.setStatus(200);
		response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		writer.write(responseString);
		writer.close();
		return null;
	}
	public ModelAndView handleRequestnotlatest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		String jsonbody = (String)session.getAttribute(JSONBODYPARAM);
		Gson gson = new Gson();
		IncomingCampaignRequest icr = gson.fromJson(jsonbody, IncomingCampaignRequest.class);
		int cases = 1;
		String type = StrUtil.nonNull(icr.getType());
		int[] campaignids = icr.getCampaignids();
		int id = campaignids[0];
		
		if("".equals(type)){
			cases = 0;
		}
		if(id == 3){
			cases=2;
		}
		List retList = new ArrayList();
		
		File file;
		if(cases==0){
			//Madhur - new client
			file = new File("C:/home/omoto/samplejson/qrgcsat.txt");
		}else if(cases==2){
			
			file = new File("C:/home/omoto/samplejson/femiint.txt");
		}
		
		else{
			//Vivek - old client
			file = new File("C:/home/omoto/samplejson/allcampaignsjson.txt");
		}
		
		String responseString = FileUtil.getFile(file);
		
		/*if(cases == 0){
			//Madhur = new client
			CampaignIdTypeJson citj = new CampaignIdTypeJson();
			citj.setId(new Long(2));
			citj.setType("CSAT");
			citj.setCampaignjson(responseString);
			
			responseString = gson.toJson(citj);
		}*/
		
		
		response.setStatus(200);
		response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		writer.write(responseString);
		writer.close();
		return null;
	}
	public ModelAndView handleRequestOld(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		String jsonbody = (String)session.getAttribute(JSONBODYPARAM);
		Gson gson = new Gson();
		IncomingCampaignRequest icr = gson.fromJson(jsonbody, IncomingCampaignRequest.class);
		String type = icr.getType();
	//	String id = new Integer(icr.getId()).toString();
		String id = "";
		File file = null;
		if("NPS".equalsIgnoreCase(type)){
			if("1".equalsIgnoreCase(id)){
				file = new File("/home/omoto/samplejsn/npsSampleOne.txt");
			}if("3".equalsIgnoreCase(id)){
				file = new File("/home/omoto/samplejsn/npsSampleTwo.txt");
			}
			
		}if("CSAT".equalsIgnoreCase(type)){
			if("2".equalsIgnoreCase(id)){
				file = new File("/home/omoto/samplejsn/csatSampleOne.txt");
			}if("4".equalsIgnoreCase(id)){
				file = new File("/home/omoto/samplejsn/csatSampleTwo.txt");
			}
			
		}
		
		String responseString = FileUtil.getFile(file);
		String str = responseString.replaceAll("\\\\", "");
		response.setStatus(200);
		response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		writer.write(str);
		writer.close();
		return null;
	}
}
