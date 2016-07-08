# JMS using Jboss5 MQ service

Configuration file for Jboss server [jbossmq-service.xml][jboss_cnf].

>Copy jbossmq-service.xml file to` [$JBOSS_HOME]/server/default/deploy/jms/`.
>There are two query create named `DLQ` and `HelloWorldQueue`.

### Files needed:
 - `JMSPutController` - Q-Creator  
 - `JMSGetController` - Q-Listener
 - `MyMessageReceiver` - Implementing class of MessageListener and the listerner for the Q.
 - `MyMessageSender` - Sending message to the Q.
 - `ContextUtil` - Q connection property file namely domain,port.
 - `JMSInitiator`- Servlet that triggers the 'MyMessageReceiver' during startup.
 
###### MyMessageReceiver.java
```
            //get the configuration from the property
			Context context = ContextUtil.getInitialContext();
			//get Queue Connection Factory from  jbossmq-service.xml file in jboss
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
			//creating the connection
			connection = connectionFactory.createConnection();
			//Creating session object
			Session session = connection.createSession(false,QueueSession.AUTO_ACKNOWLEDGE);
			/*The queue to be read .we have created two queue 1.HelloWorldQueue and 2.DQL*/
			Queue queue = (Queue) context.lookup("/queue/HelloWorldQueue");
			//Initiating the connection
			connection.start();
			//creating message consumer
			MessageConsumer consumer = session.createConsumer(queue);
			//passing the control to the Class that is responsible for Message listener
			consumer.setMessageListener(new MyMessageReceiver());
```
>This is a listener class of JMS .It reads the message 
>in the queue named `HelloWorldQueue`.
- - - - -


###### MyMessageSender.java   

```
        	//get the connection information from the property file
			Context context = ContextUtil.getInitialContext();
			//get Queue Connection Factory from  jbossmq-service.xml file in jboss
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
			//creating the connection
			connection = connectionFactory.createConnection();
			//Creating session object
			Session session = connection.createSession(false,QueueSession.AUTO_ACKNOWLEDGE);
			/*The queue to be read .we have created two queue 1.HelloWorldQueue and 2.DQL*/
			Queue queue = (Queue) context.lookup(queuename);
			//Initiating the connection
			connection.start();
			//creating message producer
			MessageProducer producer = session.createProducer(queue);
			//custom message that is send to the queue
			Message objMessage = session.createTextMessage("Hello World!");
			//sending the message to the listener
			producer.send(objMessage);
```
>The message sending part of the queue `HelloWorldQueue`

- - - - -
