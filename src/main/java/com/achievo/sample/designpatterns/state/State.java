package com.achievo.sample.designpatterns.state;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: State.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: State.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class State
{
	private String value;

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public void method1()
	{
		System.out.println("execute the first opt!");
	}

	public void method2()
	{
		System.out.println("execute the second opt!");
	}
}

/*
 * $Log: av-env.bat,v $
 */