/**
 * 
 */
package com.omototest.stubcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.google.gson.Gson;
import com.omototest.constants.Constants;
import com.omototest.jsonobjects.JsonHeader;
import com.omototest.stubcontroller.helper.ForwardUtil;

/**
 * @author Atrijit
 *
 */
public class EndPointController  implements Controller, Constants{
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Inside EndPointController handleRequest method");
		JsonHeader jsonHeader = new JsonHeader();
		Gson gson = new Gson();
		String jhstr = request.getParameter(JSONHEADERPARAM);
		String jbstr = request.getParameter(JSONBODYPARAM);
		System.out.println("JSON header: "+jhstr);
		System.out.println("JSON body: "+jbstr);
		jsonHeader = gson.fromJson(jhstr, JsonHeader.class);
		HttpSession session = request.getSession(true);
		session.setAttribute(JSONHEADERPARAM, jsonHeader);
		session.setAttribute(JSONBODYPARAM, jbstr);
		String forwardpath = ForwardUtil.getForwardAddress(jsonHeader.getProcessid());
		forwardpath = FORWARDDDENDUM + forwardpath;
		request.getRequestDispatcher(forwardpath).forward(request, response);
		return null;
	}
}
