package com.achievo.sample.designpatterns.mediator;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: User2.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: User2.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class User2 extends User
{

	public User2(Mediator mediator)
	{
		super(mediator);
	}

	@Override
	public void work()
	{
		System.out.println("user2 exe!");
	}
}

/*
 * $Log: av-env.bat,v $
 */