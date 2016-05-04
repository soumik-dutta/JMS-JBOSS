package com.omototest.jmssender;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.NamingException;

import org.springframework.jms.core.JmsTemplate;

public class MyMessageSender {
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(final Serializable message, String queuename) throws NamingException, JMSException{
		Connection connection = null;
		try {
			System.out.println("Create JNDI Context");
			Context context = ContextUtil.getInitialContext();


			System.out.println("Got context "+context);

			System.out.println("Get connection facory");
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");

			System.out.println("Create connection");
			connection = connectionFactory.createConnection();

			System.out.println("Create session");
			Session session = connection.createSession(false,
					QueueSession.AUTO_ACKNOWLEDGE);

			System.out.println("Lookup queue");
			Queue queue = (Queue) context.lookup(queuename);
			System.out.println(queue);

			System.out.println("Start connection");
			connection.start();

			System.out.println("Create producer");
			MessageProducer producer = session.createProducer(queue);
			System.out.println("message : "+message.toString());

			System.out.println("Create hello world message");
			Message objMessage=null;
			for (int i = 0; i < 100; i++) {
				objMessage = session.createTextMessage("Hello World! "+(i+1));
				producer.send(objMessage);
			}


			System.out.println("message send from sender : "+objMessage.toString());



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			if (connection != null) {
				System.out.println("close the connection");
				connection.close();
			}

		}

	}
	
	/*public void sendMessage(final Serializable message) {
		jmsTemplate.send(new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				//return session.createObjectMessage(message);
				return session.createObjectMessage(message);
			}

		});
		
	}*/
}
