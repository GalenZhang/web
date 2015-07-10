package com.achievo.sample.designpatterns.mediator;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Test.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Test.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Test
{
	public static void main(String[] args)
	{
		Mediator mediator = new MyMediator();
		mediator.createMediator();
		mediator.workAll();
	}
}

/*
 * $Log: av-env.bat,v $
 */