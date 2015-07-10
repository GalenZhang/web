package com.achievo.sample.designpatterns.interpreter;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Context.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Context.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Context
{
	private int num1;

	private int num2;

	public Context(int num1, int num2)
	{
		this.num1 = num1;
		this.num2 = num2;
	}

	public int getNum1()
	{
		return num1;
	}

	public void setNum1(int num1)
	{
		this.num1 = num1;
	}

	public int getNum2()
	{
		return num2;
	}

	public void setNum2(int num2)
	{
		this.num2 = num2;
	}
}

/*
 * $Log: av-env.bat,v $
 */