package com.achievo.sample.designpatterns.proxy;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Proxy.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Proxy.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Proxy implements Sourceable
{

	private Source source;

	public Proxy()
	{
		super();
		this.source = new Source();
	}

	@Override
	public void method()
	{
		before();
		source.method();
		atfer();
	}

	private void atfer()
	{
		System.out.println("after proxy!");
	}

	private void before()
	{
		System.out.println("before proxy!");
	}
}

/*
 * $Log: av-env.bat,v $
 */