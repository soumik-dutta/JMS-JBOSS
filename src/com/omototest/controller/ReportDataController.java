/**
 * 
 */
package com.omototest.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.NameValuePair;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.google.gson.Gson;
import com.omototest.constants.Constants;
import com.omototest.dao.implementation.OmotoReportDAO;
import com.omototest.jsonobjects.ReportJson;

/**
 * @author Atrijit
 *
 */
public class ReportDataController implements Controller, Constants{
	private OmotoReportDAO omotoReportDAO;
	public OmotoReportDAO getOmotoReportDAO() {
		return omotoReportDAO;
	}
	public void setOmotoReportDAO(OmotoReportDAO omotoReportDAO) {
		this.omotoReportDAO = omotoReportDAO;
	}
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List reports = omotoReportDAO.getAllRecords();
		ReportJson rj = new ReportJson();
		rj.setDatalist(reports);
		Gson gson = new Gson();
		String responseString = gson.toJson(rj);
		response.setStatus(200);
		response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		writer.write(responseString);
		writer.close();
		return null;
	}
	public ModelAndView handleRequestOld(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List reports = omotoReportDAO.getAllRecords();
		Gson gson = new Gson();
		
		ReportJson rj = new ReportJson();
		rj.setDatalist(reports);
		
		List filters = new ArrayList();
		
		NameValuePair a = new NameValuePair();
		a.setName("region");
		a.setValue("Region");
		filters.add(a);
		
		NameValuePair b = new NameValuePair();
		b.setName("city");
		b.setValue("City");
		filters.add(b);
		
		rj.setFilters(filters);
		
		List segments = new ArrayList();
		
		NameValuePair c = new NameValuePair();
		c.setName("scname");
		c.setValue("SC Name");
		segments.add(c);
		
		NameValuePair d = new NameValuePair();
		d.setName("segments");
		d.setValue("Segments");
		segments.add(d);
		
		rj.setSegments(segments);
		
		String responseString = gson.toJson(rj);
	//	System.out.println("from omototest ReportDataController  responseString:: "+responseString);
		response.setStatus(200);
		response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		writer.write(responseString);
		writer.close();
		return null;
	}
	
}
