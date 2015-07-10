package com.achievo.sample.designpatterns.bridge;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: SourceSub1.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: SourceSub1.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class SourceSub1 implements Sourceable
{

	@Override
	public void method()
	{
		System.out.println("this is the first sub!");
	}
}

/*
 * $Log: av-env.bat,v $
 */