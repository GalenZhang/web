package com.achievo.sample.designpatterns.decorator;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: DecoratorTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: DecoratorTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class DecoratorTest
{
	public static void main(String[] args)
	{
		Sourceable source = new Source();
		Sourceable obj = new Decorator(source);
		obj.method();
	}
}

/*
 * $Log: av-env.bat,v $
 */