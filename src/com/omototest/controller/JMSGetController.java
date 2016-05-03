package com.omototest.controller;

import com.omototest.constants.Constants;
import com.omototest.jmsreceiver.MyMessageReceiver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by omoto on 3/5/16.
 */
public class JMSGetController implements Controller, Constants {

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        MyMessageReceiver myMessageReceiver=new MyMessageReceiver();
        myMessageReceiver.readMessage();

        return null;
    }

}
