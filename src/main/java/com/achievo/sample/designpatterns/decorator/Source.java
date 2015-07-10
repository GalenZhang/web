package com.achievo.sample.designpatterns.decorator;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Source.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Source.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Source implements Sourceable
{

	@Override
	public void method()
	{
		System.out.println("the original method!");
	}
}

/*
 * $Log: av-env.bat,v $
 */