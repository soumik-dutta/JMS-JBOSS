/**
 * 
 */
package com.omototest.stubcontroller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.google.gson.Gson;
import com.omototest.constants.Constants;
import com.omototest.jsonobjects.JsonHeader;
import com.omototest.jsonobjects.SDKResponse;

/**
 * @author Atrijit
 *
 */
public class SDKOutController implements Controller, Constants{
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Inside SDKOutController");
		HttpSession session = request.getSession(true);
		JsonHeader jh = (JsonHeader)session.getAttribute(JSONHEADERPARAM);
		SDKResponse sdkr = new SDKResponse();
		sdkr.setStatus("SUCCESS");
		Gson gson = new Gson();
		String resp = gson.toJson(sdkr);
		System.out.println("resp xxx: "+resp);
		response.setStatus(200);
		response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		writer.write(resp);
		writer.close();
		return null;
		
	}
}
