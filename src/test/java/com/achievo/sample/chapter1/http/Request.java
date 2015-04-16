package com.achievo.sample.chapter1.http;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Request.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Request.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Apr 16, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Request
{
	private int encode;

	private String command;

	private int commandLength;

	public int getEncode()
	{
		return encode;
	}

	public void setEncode(int encode)
	{
		this.encode = encode;
	}

	public String getCommand()
	{
		return command;
	}

	public void setCommand(String command)
	{
		this.command = command;
	}

	public int getCommandLength()
	{
		return commandLength;
	}

	public void setCommandLength(int commandLength)
	{
		this.commandLength = commandLength;
	}

}

/*
 * $Log: av-env.bat,v $
 */