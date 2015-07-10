package com.achievo.sample.designpatterns.factory.common;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: SendFactory.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: SendFactory.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class SendFactory
{

	public Sender produce(String type)
	{
		if ("mail".equals(type))
		{
			return new MailSender();
		}
		else if ("sms".equals(type))
		{
			return new SmsSender();
		}
		else
		{
			System.out.println("请输入正确的类型!");
			return null;
		}
	}
}

/*
 * $Log: av-env.bat,v $
 */