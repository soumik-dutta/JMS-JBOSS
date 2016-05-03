package com.omototest.jmsreceiver;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.omototest.jmsvo.JmsVo;

public class JMSReceiver implements MessageListener{
	public void onMessage(Message message) {
		
		      try {
		
		    	  ObjectMessage obj = (ObjectMessage)message;
		    	  
					JmsVo jv = (JmsVo)obj;
					System.out.println("We got "+jv.getName());
		
		      } catch (Exception e) {
		
		          // TODO Auto-generated catch block
		
		          e.printStackTrace();
		
		      }
		
		  }

}
