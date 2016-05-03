/**
 * 
 */
package com.omototest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.omototest.constants.Constants;
import com.omototest.jmssender.MyMessageSender;
import com.omototest.jmsvo.JmsVo;

/**
 * @author Atrijit
 *
 */
public class JMSPutController implements Controller, Constants {
	
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JmsVo jv = new JmsVo();
		jv.setName("Hello World from Queue");
		
		new MyMessageSender().sendMessage(jv, "/queue/HelloWorldQueue");
		return null;
	}
	
}
