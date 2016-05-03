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
import com.omototest.jsonobjects.IncomingRegistration;
import com.omototest.jsonobjects.JsonHeader;

/**
 * @author Atrijit
 *
 */
public class RegistrationController implements Controller, Constants{
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Inside RegistrationController");
		HttpSession session = request.getSession(true);
		JsonHeader jh = (JsonHeader)session.getAttribute(JSONHEADERPARAM);
		String jsonbody = (String)session.getAttribute(JSONBODYPARAM);
		Gson gson = new Gson();
		IncomingRegistration ir = gson.fromJson(jsonbody, IncomingRegistration.class);
		
		System.out.println(jh.getDeviceid());
		System.out.println(jh.getProcessid());
		
		System.out.println(ir.getFirstname());
		System.out.println(ir.getLastname());
		System.out.println(ir.getEmail());
		System.out.println(ir.getIndustry());
		response.setStatus(200);
		response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		writer.close();
		return null;
		
	}
}
