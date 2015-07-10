package com.achievo.sample.designpatterns.command;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Invoker.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Invoker.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Invoker
{
	private Command command;

	public Invoker(Command command)
	{
		this.command = command;
	}

	public void action()
	{
		command.exe();
	}
}

/*
 * $Log: av-env.bat,v $
 */