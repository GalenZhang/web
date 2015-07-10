package com.achievo.sample.designpatterns.interpreter;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Minus.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Minus.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Minus implements Expression
{

	@Override
	public int interpret(Context context)
	{
		return context.getNum1() - context.getNum2();
	}
}

/*
 * $Log: av-env.bat,v $
 */