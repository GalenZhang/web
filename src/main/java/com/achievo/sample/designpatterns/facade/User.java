package com.achievo.sample.designpatterns.facade;

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
public class User
{
	public static void main(String[] args)
	{
		Computer computer = new Computer();
		computer.startup();
		computer.shutdown();
	}
}

/*
 * $Log: av-env.bat,v $
 */