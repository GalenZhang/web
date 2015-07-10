package com.achievo.sample.designpatterns.decorator;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Decorator.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Decorator.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Decorator implements Sourceable
{

	private Sourceable source;

	public Decorator(Sourceable source)
	{
		super();
		this.source = source;
	}

	@Override
	public void method()
	{
		System.out.println("before decorator!");
		source.method();
		System.out.println("after decorator!");
	}
}

/*
 * $Log: av-env.bat,v $
 */