/**
 * 
 */
package com.omototest.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.omototest.constants.Constants;
import com.omototest.dao.implementation.FormResultDAO;
import com.omototest.model.FormResult;
import com.omototest.utils.StrUtil;

/**
 * @author Atrijit
 *
 */
public class QuestionUpdateController implements Controller, Constants{
	private FormResultDAO formResultDAO;
	public FormResultDAO getFormResultDAO() {
		return formResultDAO;
	}
	public void setFormResultDAO(FormResultDAO formResultDAO) {
		this.formResultDAO = formResultDAO;
	}
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String jsonstring = StrUtil.nonNull(request.getParameter(JSONSTRING));
		jsonstring = StrUtil.deSlash(jsonstring);
		jsonstring = jsonstring.trim();
		FormResult fr = new FormResult();
		fr.setOmotoresponse(jsonstring);
		formResultDAO.addOrUpdateRecord(fr);
		System.out.println("*************************RESPONSE FROM OMOTO TEST*************************");
		System.out.println(jsonstring);
		response.setStatus(200);
		response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		writer.write("");
		writer.close();
		return null;
	}
}
