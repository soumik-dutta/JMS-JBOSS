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
import com.omototest.jsonobjects.LoginRequest;
import com.omototest.jsonobjects.LoginResponse;
import com.omototest.utils.StrUtil;

/**
 * @author Atrijit
 * 
 */
public class LoginController implements Controller, Constants {
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String username = StrUtil.nonNull(request.getParameter("username"));
		Gson gson = new Gson();
		username = StrUtil.deSlash(username);
		username = username.trim();
		System.out.println("from omototest LoginController username:: "+username);
		LoginResponse loginResponse = new LoginResponse();
		if ("sailesh".equalsIgnoreCase(username)) {
			loginResponse.setResponse(new Boolean(true));
		} else {
			loginResponse.setResponse(new Boolean(false));
		}
		String responseString = gson.toJson(loginResponse);
		System.out.println("from omototest LoginController  responseString:: "+responseString);
		response.setStatus(200);
		response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		writer.write(responseString);
		writer.close();
		return null;
	}
}
