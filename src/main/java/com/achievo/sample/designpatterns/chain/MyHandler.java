package com.achievo.sample.designpatterns.chain;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: MyHandler.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: MyHandler.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class MyHandler extends AbstractHandler implements Handler
{

	private String name;

	public MyHandler(String name)
	{
		this.name = name;
	}

	@Override
	public void operator()
	{
		System.out.println(name + "deal!");
		if (getHandler() != null)
		{
			getHandler().operator();
		}
	}
}

/*
 * $Log: av-env.bat,v $
 */