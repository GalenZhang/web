package com.achievo.sample.designpatterns.adapter;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Wrapper.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Wrapper.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Wrapper implements Targetable
{

	private Source source;

	public Wrapper(Source source)
	{
		super();
		this.source = source;
	}

	@Override
	public void method2()
	{
		System.out.println("this is the targetable method!");
	}

	@Override
	public void method1()
	{
		source.method1();
	}
}

/*
 * $Log: av-env.bat,v $
 */