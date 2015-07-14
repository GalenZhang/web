package com.achievo.sample.chapter1.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
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
 *  File: Sender.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Sender.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 14, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Sender
{
	@Test
	public void testSend()
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
		// MessageProducer：消息发送者
		MessageProducer producer = null;
		try
		{
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("MessageQueue");
			producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			ObjectMessage message = session.createObjectMessage("Hello everyone!");
			producer.send(message);
			session.commit();
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
	public void testSendTopic()
	{
		// ConnectionFactory ：连接工厂，JMS 用它创建连接
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, "tcp://10.50.90.54:61616");
		// Connection ：JMS 客户端到JMS Provider 的连接
		Connection connection = null;
		// Session： 一个发送或接收消息的线程
		Session session = null;
		// MessageProducer：消息发送者
		MessageProducer producer = null;
		try
		{
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Topic topic = session.createTopic("MessageTopic");
			producer = session.createProducer(topic);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			TextMessage message = session.createTextMessage();
			message.setText("message_hello_topic");
			producer.send(message);
			session.commit();
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