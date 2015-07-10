package com.achievo.sample.designpatterns.factory.common;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: MailSender.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: MailSender.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class MailSender implements Sender
{
	@Override
	public void Send()
	{
		System.out.println("this is mailsender!");
	}
}

/*
 * $Log: av-env.bat,v $
 */