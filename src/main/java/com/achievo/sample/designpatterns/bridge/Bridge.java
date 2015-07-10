package com.achievo.sample.designpatterns.bridge;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Bridge.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Bridge.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public abstract class Bridge
{
	private Sourceable source;

	public void method()
	{
		source.method();
	}

	public Sourceable getSource()
	{
		return source;
	}

	public void setSource(Sourceable source)
	{
		this.source = source;
	}
}

/*
 * $Log: av-env.bat,v $
 */