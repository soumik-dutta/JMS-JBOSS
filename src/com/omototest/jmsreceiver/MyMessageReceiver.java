/**
 * 
 */
package com.omototest.jmsreceiver;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.NamingException;

import com.omototest.jmssender.ContextUtil;
import com.omototest.jmsvo.JmsVo;

/**
 * @author Atrijit
 *
 */
public class MyMessageReceiver implements MessageListener{

	public void onMessage(Message message) {
		try {
			System.out.println("message received in Receiver :");
			/*ObjectMessage obj = (ObjectMessage)message;
			JmsVo jv = (JmsVo)obj;
			System.out.println("We got "+jv.getName());*/

			System.out.print(((TextMessage) message).getText());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readMessage() throws NamingException, JMSException {
		Connection connection = null;
		try {

			Context context = ContextUtil.getInitialContext();
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");

			System.out.println("Create connection");
			connection = connectionFactory.createConnection();

			System.out.println("Create session");
			Session session = connection.createSession(false,
					QueueSession.AUTO_ACKNOWLEDGE);

			System.out.println("Lookup queue");
			Queue queue = (Queue) context.lookup("/queue/HelloWorldQueue");

			System.out.println("Start connection");
			connection.start();

			System.out.println("Create consumer : ");
			MessageConsumer consumer = session.createConsumer(queue);


			System.out.println("set message listener");
			consumer.setMessageListener(new MyMessageReceiver());



		} finally {
			if (connection != null) {
				System.out.println("close the connection");
				//connection.close();
			}
		}
	}
}
