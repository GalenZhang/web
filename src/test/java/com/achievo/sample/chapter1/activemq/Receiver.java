package com.achievo.sample.chapter1.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Receiver.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Receiver.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 14, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Receiver
{
	@Test
	public void testReceive()
	{
		// ConnectionFactory ：连接工厂，JMS 用它创建连接
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, "tcp://10.50.90.54:61616");
		// Connection ：JMS 客户端到JMS Provider 的连接
		Connection connection = null;
		// Session： 一个发送或接收消息的线程
		Session session = null;
		// Destination ：消息的目的地;消息发送给谁.
		Destination destination = null;
		// 消费者，消息接收者
		MessageConsumer consumer = null;

		try
		{
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("MessageQueue");
			consumer = session.createConsumer(destination);

			while (true)
			{
				// 设置接收者接收消息的时间，为了便于测试，这里谁定为100s
				ObjectMessage message = (ObjectMessage) consumer.receive(100000);
				if (message != null)
				{
					String messageContent = (String) message.getObject();
					System.out.println("收到消息: " + messageContent);
				}
				else
				{
					break;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (null != connection)
					connection.close();
			}
			catch (Throwable ignore)
			{
			}
		}
	}

	@Test
	public void testReceiveTopic()
	{
		// ConnectionFactory ：连接工厂，JMS 用它创建连接
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, "tcp://10.50.90.54:61616");
		// Connection ：JMS 客户端到JMS Provider 的连接
		Connection connection = null;
		// Session： 一个发送或接收消息的线程
		Session session = null;
		// 消费者，消息接收者
		MessageConsumer consumer = null;

		try
		{
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Topic topic = session.createTopic("MessageTopic");
			consumer = session.createConsumer(topic);

			consumer.setMessageListener(new MessageListener()
			{

				@Override
				public void onMessage(Message message)
				{
					TextMessage tm = (TextMessage) message;
					try
					{
						System.out.println(tm.getText());
					}
					catch (JMSException e)
					{
						e.printStackTrace();
					}
				}

			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (null != connection)
					connection.close();
			}
			catch (Throwable ignore)
			{
			}
		}
	}
}

/*
 * $Log: av-env.bat,v $
 */