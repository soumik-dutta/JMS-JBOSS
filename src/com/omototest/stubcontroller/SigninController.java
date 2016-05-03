/**
 * 
 */
package com.omototest.stubcontroller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.google.gson.Gson;
import com.omototest.constants.Constants;
import com.omototest.jsonobjects.Campaign;
import com.omototest.jsonobjects.CampaignListJson;
import com.omototest.jsonobjects.IncomingLogin;
import com.omototest.jsonobjects.JsonHeader;
import com.omototest.jsonobjects.LoginStatus;
import com.omototest.jsonobjects.TabCampaignListJson;
import com.omototest.jsonobjects.TabLoginResponseJson;

/**
 * @author Atrijit
 *
 */
public class SigninController implements Controller, Constants{
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Inside SigninController");
		HttpSession session = request.getSession(true);
		JsonHeader jh = (JsonHeader)session.getAttribute(JSONHEADERPARAM);
		String jsonbody = (String)session.getAttribute(JSONBODYPARAM);
		Gson gson = new Gson();
		IncomingLogin il = gson.fromJson(jsonbody, IncomingLogin.class);
		System.out.println(jh.getDeviceid());
		System.out.println(jh.getProcessid());
		System.out.println(il.getEmail());
		System.out.println(il.getPassword());
		boolean loginsuccess = false;
		int cases = 0;
		if("kushal@customerguru.in".equalsIgnoreCase(il.getEmail())){
			cases = 0;
			loginsuccess = true;
		}else if("trivedirushi1@gmail.com".equalsIgnoreCase(il.getEmail())){
			cases = 0;
			loginsuccess = true;
		}
		/*if("madhur@omoto.io".equalsIgnoreCase(il.getEmail())){
			cases = 0;
			loginsuccess = true;
		}else if("vivek.a@omoto.io".equalsIgnoreCase(il.getEmail())){
			cases = 1;
			loginsuccess = true;
		}else if("femiint@omoto.io".equalsIgnoreCase(il.getEmail())){
			cases = 2;
			loginsuccess = true;
		}*/
		//if(!"madhur@omoto.io".equalsIgnoreCase(il.getEmail())){
		if(!loginsuccess){
			
			response.setStatus(200);
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter writer = response.getWriter();
			LoginStatus ls = new LoginStatus();
			ls.setLoginstatus(false);
			String temp = gson.toJson(ls);
			writer.write(temp);
			writer.close();
			return null;
		}
		if(cases == 0){
			response.setStatus(200);
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter writer = response.getWriter();
		//	List responses = getResponseString();
			List responses = getResponseStringSmileMerchant();
			TabCampaignListJson tclj = new TabCampaignListJson();
			tclj.setCampaigndescription("Smile Merchants Survey");
			tclj.setCampaignid(new Long(17));
			tclj.setRespondents(new Long(23));
			tclj.setScore(new Long(17));
			tclj.setCampaignname("Smile Merchants NPS");
			tclj.setType("NPS");
			Map scoreMap = fillScoreMap();
			Map responsesMap = fillResponsesMap();
			tclj.setScoreMap(scoreMap);
			tclj.setResponses(responsesMap);
			List list = new ArrayList();
			list.add(tclj);
			TabLoginResponseJson tlrj = new TabLoginResponseJson();
			tlrj.setCampaignlist(list);
			tlrj.setDevicename("Smile Merchants Tab");
			String responseString = gson.toJson(tlrj);
			System.out.println("List responseString: "+responseString);
			writer.write(responseString);
			writer.close();
			return null;
		}else if(cases==1){
			response.setStatus(200);
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter writer = response.getWriter();
			List responses = getResponseStringOld();
			String responseString = gson.toJson(responses);
			writer.write(responseString);
			writer.close();
			return null;
		}else if(cases==2){
			response.setStatus(200);
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter writer = response.getWriter();
			List responses = getResponseStringFemiint();
			CampaignListJson clj = new CampaignListJson();
			clj.setDevicename("Femiint Tab");
			clj.setCampaignlist(responses);
			String responseString = gson.toJson(clj);
			writer.write(responseString);
			writer.close();
			return null;
		}
		return null;
		
	}
	
	private List getResponseStringSmileMerchant(){
		List list = new ArrayList();
		
		Campaign c2 = new Campaign();
		c2.setCampaigndescription("Smile Merchant NPS Campaign");
		c2.setCampaignid(new Long(17));
		c2.setCampaignname("Smile Merchant Campaign");
		c2.setRespondents(new Long(27));
		c2.setScore(new Long(3));
		c2.setType("NPS");
		list.add(c2);
		return list;
	}
	
	private Map fillScoreMap() {
		Map map = new HashMap();
		map.put("24-08-2015", new Long(3));
		map.put("25-08-2015", new Long(14));
		map.put("26-08-2015", new Long(11));
		map.put("27-08-2015", new Long(6));
		map.put("28-08-2015", new Long(7));
		map.put("29-08-2015", new Long(13));
		map.put("30-08-2015", new Long(9));
		return map;
	}

	private Map fillResponsesMap() {
		Map map = new HashMap();
		map.put("24-08-2015", new Long(13));
		map.put("25-08-2015", new Long(24));
		map.put("26-08-2015", new Long(21));
		map.put("27-08-2015", new Long(16));
		map.put("28-08-2015", new Long(17));
		map.put("29-08-2015", new Long(10));
		map.put("30-08-2015", new Long(19));
		return map;

	}
	
	private List getResponseStringFemiint(){
		List list = new ArrayList();
		
		Campaign c2 = new Campaign();
		c2.setCampaigndescription("Femiint CSAT Campaign");
		c2.setCampaignid(new Long(3));
		c2.setCampaignname("Femiint Campaign");
		c2.setRespondents(new Long(27));
		c2.setScore(new Long(3));
		c2.setType("CSAT");
		list.add(c2);
		return list;
	}
	private List getResponseString(){
		List list = new ArrayList();
		
		Campaign c2 = new Campaign();
		c2.setCampaigndescription("Advanced Hair Studio CSAT Campaign");
		c2.setCampaignid(new Long(2));
		c2.setCampaignname("AHS Campaign");
		c2.setRespondents(new Long(19));
		c2.setScore(new Long(3));
		c2.setType("CSAT");
		
		Campaign c1 = new Campaign();
		c1.setCampaigndescription("Advanced Hair Studio NPS Campaign");
		c1.setCampaignid(new Long(1));
		c1.setCampaignname("AHS Campaign");
		c1.setRespondents(new Long(19));
		c1.setScore(new Long(3));
		c1.setType("NPS");
		
		list.add(c1);
		list.add(c2);
		return list;
	}
	private List getResponseStringOld(){
		List list = new ArrayList();
		Campaign c1 = new Campaign();
		c1.setCampaigndescription("Omotenashi Hospital NPS Campaign");
		c1.setCampaignid(new Long(1));
		c1.setCampaignname("NPS Campaign #1");
		c1.setRespondents(new Long(8));
		c1.setScore(new Long(21));
		c1.setType("NPS");
		
		Campaign c2 = new Campaign();
		c2.setCampaigndescription("Omotenashi Hospital CSAT Campaign");
		c2.setCampaignid(new Long(2));
		c2.setCampaignname("CSAT Campaign #1");
		c2.setRespondents(new Long(19));
		c2.setScore(new Long(3));
		c2.setType("CSAT");
		
		Campaign c3 = new Campaign();
		c3.setCampaigndescription("Omotenashi Hotel NPS Campaign");
		c3.setCampaignid(new Long(3));
		c3.setCampaignname("NPS Campaign #2");
		c3.setRespondents(new Long(124));
		c3.setScore(new Long(22));
		c3.setType("NPS");
		
		Campaign c4 = new Campaign();
		c4.setCampaigndescription("Omotenashi Hotel CSAT Campaign");
		c4.setCampaignid(new Long(4));
		c4.setCampaignname("CSAT Campaign #2");
		c4.setRespondents(new Long(76));
		c4.setScore(new Long(4));
		c4.setType("CSAT");
		
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		return list;
	}
}
