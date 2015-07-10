package com.achievo.sample.designpatterns.factory.multiple;

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

	public Sender produceMail()
	{
		return new MailSender();
	}

	public Sender produceSms()
	{
		return new SmsSender();
	}
}

/*
 * $Log: av-env.bat,v $
 */