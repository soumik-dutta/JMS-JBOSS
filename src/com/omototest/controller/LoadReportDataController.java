/**
 * 
 */
package com.omototest.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.omototest.constants.Constants;
import com.omototest.dao.implementation.OmotoReportDAO;
import com.omototest.model.OmotoReport;
import com.omototest.utils.FileUtil;
import com.omototest.utils.StrUtil;

/**
 * @author Atrijit
 * 
 */
public class LoadReportDataController implements Controller, Constants {
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
		for (int i = 0; i < reports.size(); i++) {
			OmotoReport or = (OmotoReport) reports.get(i);
			Date dt = or.getResponsedate();
			String datestr = StrUtil.getDateString(dt, DATEFORMATSTR);
			or.setResponsedatestr(datestr);
			omotoReportDAO.addOrUpdateRecord(or);
		}
		return null;
	}

	public ModelAndView handleRequestOld(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		File file = new File(DATALOADFILEPATH);
		List list = FileUtil.readFile(file);
		System.out.println("list size: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			String temp = (String) list.get(i);
			String[] temparray = temp.split(",");
			String CustomerName = "";
			String Campaign = "NPS Benchmarking Campaign";

			String CustomerId = "";
			String NPSStrResp = "";
			String RespDate = "";
			String City = "";
			String Region = "";
			String CampaignID = "";
			String SCName = "";
			String segment = "";
			// Yadu Kumar,SC Cunningham Road,Bangalore,South1,LOYALS,9

			CustomerName = temparray[0];
			CustomerName = CustomerName.trim();

			Long clientIdLong = new Long(i + 1);
			NPSStrResp = temparray[5];
			NPSStrResp = NPSStrResp.trim();

			segment = temparray[4];
			segment = segment.trim();

			Long npsresponse = new Long(NPSStrResp);
			SCName = temparray[1];
			SCName = SCName.trim();

			Date responseDate = new Date();

			City = temparray[2];
			City = City.trim();

			Region = temparray[3];
			Region = Region.trim();

			Long campaignIdLong = new Long(1);

			OmotoReport or = new OmotoReport();
			//or.setId(campaignIdLong);
			or.setCampaign(Campaign);
			or.setSegments(segment);
			or.setCampaignid(campaignIdLong);
			or.setCity(City);
			or.setClientid(clientIdLong);
			or.setClientname(CustomerName);
			or.setRegion(Region);
			or.setNpsscore(npsresponse);
			or.setResponsedate(responseDate);
			or.setCampaignid(new Long(100));
			or.setResponsedate(new Date());
			or.setScname(SCName);

			omotoReportDAO.addOrUpdateRecord(or);

		}

		return null;
	}
}
