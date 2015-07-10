package com.achievo.sample.designpatterns.factory.staticz;

import com.achievo.sample.designpatterns.factory.common.Sender;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: FactoryTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: FactoryTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class FactoryTest
{
	public static void main(String[] args)
	{
		Sender sender = SendFactory.produceMail();
		sender.Send();
	}
}

/*
 * $Log: av-env.bat,v $
 */