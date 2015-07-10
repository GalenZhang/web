package com.achievo.sample.designpatterns.template;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Plus.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Plus.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Plus extends AbstractCalculator
{

	@Override
	public int calculate(int num1, int num2)
	{
		return num1 + num2;
	}
}

/*
 * $Log: av-env.bat,v $
 */