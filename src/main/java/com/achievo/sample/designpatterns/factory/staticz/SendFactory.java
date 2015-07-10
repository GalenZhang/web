package com.achievo.sample.designpatterns.factory.staticz;

import com.achievo.sample.designpatterns.factory.common.MailSender;
import com.achievo.sample.designpatterns.factory.common.Sender;
import com.achievo.sample.designpatterns.factory.common.SmsSender;

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
	public static Sender produceMail()
	{
		return new MailSender();
	}

	public static Sender produceSms()
	{
		return new SmsSender();
	}
}

/*
 * $Log: av-env.bat,v $
 */