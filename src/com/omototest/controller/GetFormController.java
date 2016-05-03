/**
 * 
 */
package com.omototest.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.google.gson.Gson;
import com.omototest.constants.Constants;
import com.omototest.jsonobjects.GetFormRequest;
import com.omototest.jsonobjects.GetFormResponse;
import com.omototest.utils.StrUtil;

/**
 * @author Atrijit
 * 
 */
public class GetFormController implements Controller, Constants {
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String clientid = StrUtil.nonNull(request.getParameter("clientid"));
		
		Gson gson = new Gson();
		clientid = StrUtil.deSlash(clientid);
		clientid = clientid.trim();
		System.out.println("from omototest GetFormController clientid:: "+clientid);
		GetFormResponse gfr = new GetFormResponse();
		gfr.setClientid(clientid);
		String formname = StrUtil.getUniqueId();
		gfr.setFormname(formname);
		Integer displaytype = StrUtil.randomValue();
		gfr.setDisplaytype(displaytype);
		Integer formtype = StrUtil.randomValue();
		gfr.setFormtype(formtype);
		String responseString = gson.toJson(gfr);
		System.out.println("from omototest GetFormController  responseString:: "+responseString);
		response.setStatus(200);
		response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		writer.write(responseString);
		writer.close();
		return null;
	}
}
