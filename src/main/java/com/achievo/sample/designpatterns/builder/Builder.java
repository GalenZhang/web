package com.achievo.sample.designpatterns.builder;

import java.util.ArrayList;
import java.util.List;

import com.achievo.sample.designpatterns.factory.common.MailSender;
import com.achievo.sample.designpatterns.factory.common.Sender;
import com.achievo.sample.designpatterns.factory.common.SmsSender;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Builder.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Builder.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Builder
{
	private List<Sender> list = new ArrayList<Sender>();

	public void produceMailSender(int count)
	{
		for (int i = 0; i < count; i++)
		{
			list.add(new MailSender());
		}
	}

	public void produceSmsSender(int count)
	{
		for (int i = 0; i < count; i++)
		{
			list.add(new SmsSender());
		}
	}
}

/*
 * $Log: av-env.bat,v $
 */