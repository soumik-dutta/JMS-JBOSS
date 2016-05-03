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
import com.omototest.jsonobjects.CampaignIdTypeJson;
import com.omototest.jsonobjects.SDKJsonHeader;
import com.omototest.utils.FileUtil;

/**
 * @author Atrijit
 *
 */
public class SDKInController implements Controller, Constants{
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Inside SDKInController");
		HttpSession session = request.getSession(true);
		String jhstr = request.getParameter(JSONHEADERPARAM);
		String jbstr = request.getParameter(JSONBODYPARAM);
		Gson gson = new Gson();
		SDKJsonHeader sjh = gson.fromJson(jhstr, SDKJsonHeader.class);
		Long showtype  = sjh.getShowtype();
		int shint = showtype.intValue();
		if(shint == 0){
			System.out.println("Got 0");
			List send = new ArrayList();
			CampaignIdTypeJson citj = new CampaignIdTypeJson();
			citj.setId(new Long(1));
			citj.setType("NPS");
		//	String nps = FileUtil.getFile(new File("C:/home/omoto/samplejson/sdknps.txt"));
			String nps = FileUtil.getFile(new File("/home/omoto/samplejsn/sdknps.txt"));
			citj.setCampaignjson(nps);
			
			CampaignIdTypeJson citj2 = new CampaignIdTypeJson();
			citj2.setId(new Long(2));
			citj2.setType("CSAT");
			String csat = FileUtil.getFile(new File("/home/omoto/samplejsn/sdkcsat.txt"));
			citj2.setCampaignjson(csat);
			
			CampaignIdTypeJson citj3 = new CampaignIdTypeJson();
			citj3.setId(new Long(3));
			citj3.setType("NPSSCALE");
			String npssimple = FileUtil.getFile(new File("/home/omoto/samplejsn/npssimple.txt"));
			citj3.setCampaignjson(npssimple);
			
			CampaignIdTypeJson citj4 = new CampaignIdTypeJson();
			citj4.setId(new Long(4));
			citj4.setType("CSATSCALE");
			String csatsimple = FileUtil.getFile(new File("/home/omoto/samplejsn/csatsimple.txt"));
			citj4.setCampaignjson(csatsimple);
			
			
			send.add(citj);
			send.add(citj2);
			send.add(citj3);
			send.add(citj4);
			
			String resp = gson.toJson(send);
			System.out.println("resp 0: "+resp);
			response.setStatus(200);
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter writer = response.getWriter();
			writer.write(resp);
			writer.close();
			return null;
		}else if(shint == 1){
			System.out.println("Got 1");
			List send = new ArrayList();
			CampaignIdTypeJson citj = new CampaignIdTypeJson();
			citj.setId(new Long(1));
			citj.setType("NPS");
			String nps = FileUtil.getFile(new File("/home/omoto/samplejsn/sdknps.txt"));
			citj.setCampaignjson(nps);
			send.add(citj);
			String resp = gson.toJson(send);
			System.out.println("resp 1: "+resp);
			response.setStatus(200);
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter writer = response.getWriter();
			writer.write(resp);
			writer.close();
			return null;
		}else if(shint == 2){
			System.out.println("Got 2");
			List send = new ArrayList();
			CampaignIdTypeJson citj2 = new CampaignIdTypeJson();
			citj2.setId(new Long(2));
			citj2.setType("CSAT");
			String csat = FileUtil.getFile(new File("/home/omoto/samplejsn/sdkcsat.txt"));
			citj2.setCampaignjson(csat);
			send.add(citj2);
			String resp = gson.toJson(send);
			System.out.println("resp 2: "+resp);
			response.setStatus(200);
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter writer = response.getWriter();
			writer.write(resp);
			writer.close();
			return null;
		}
		return null;
	}
}
