package com.achievo.sample.designpatterns.mediator;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: User.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: User.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public abstract class User
{

	private Mediator mediator;

	public Mediator getMediator()
	{
		return mediator;
	}

	public User(Mediator mediator)
	{
		this.mediator = mediator;
	}

	public abstract void work();
}

/*
 * $Log: av-env.bat,v $
 */