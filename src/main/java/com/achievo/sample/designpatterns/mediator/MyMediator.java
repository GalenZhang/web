package com.achievo.sample.designpatterns.mediator;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: MyMediator.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: MyMediator.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class MyMediator implements Mediator
{
	private User user1;

	private User user2;

	public User getUser1()
	{
		return user1;
	}

	public User getUser2()
	{
		return user2;
	}

	@Override
	public void createMediator()
	{
		user1 = new User1(this);
		user2 = new User2(this);
	}

	@Override
	public void workAll()
	{
		user1.work();
		user2.work();
	}
}

/*
 * $Log: av-env.bat,v $
 */