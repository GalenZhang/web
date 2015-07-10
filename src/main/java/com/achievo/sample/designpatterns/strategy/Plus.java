package com.achievo.sample.designpatterns.strategy;

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
public class Plus extends AbstractCalculator implements ICalculator
{

	@Override
	public int calculate(String exp)
	{
		int arrayInt[] = split(exp, "\\+");
		return arrayInt[0] + arrayInt[1];
	}
}

/*
 * $Log: av-env.bat,v $
 */