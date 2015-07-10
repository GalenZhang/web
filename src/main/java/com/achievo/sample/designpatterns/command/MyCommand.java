package com.achievo.sample.designpatterns.command;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: MyCommand.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: MyCommand.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class MyCommand implements Command
{

	private Receiver receiver;

	public MyCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}

	@Override
	public void exe()
	{
		receiver.action();
	}
}

/*
 * $Log: av-env.bat,v $
 */