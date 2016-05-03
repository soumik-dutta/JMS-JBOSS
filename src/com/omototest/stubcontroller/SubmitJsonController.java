/**
 * 
 */
package com.omototest.stubcontroller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.google.gson.Gson;
import com.omototest.constants.Constants;
import com.omototest.jsonobjects.SubmitJsonResponse;
import com.omototest.utils.StrUtil;

/**
 * @author Atrijit
 *
 */
public class SubmitJsonController implements Controller, Constants{
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	//	Integer randInt = StrUtil.randomValue();
		//int rint = randInt.intValue();
		//int rint = 1;
		Gson gson = new Gson();
	/*	if(rint==0){
			//false
			response.setStatus(401);
			SubmitJsonResponse sjr = new SubmitJsonResponse();
			sjr.setStatus(false);
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter writer = response.getWriter();
			String resp = gson.toJson(sjr);
			writer.write(resp);
			writer.close();
			return null;
		}else{*/
			//true
			response.setStatus(200);
			SubmitJsonResponse sjr = new SubmitJsonResponse();
			sjr.setStatus(true);
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter writer = response.getWriter();
			String resp = gson.toJson(sjr);
			writer.write(resp);
			writer.close();
			return null;
	//	}
		
	}
}
