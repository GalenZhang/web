package com.achievo.sample.chapter1.tcp;
/**
 * <pre>
 * 
 *  Accela Automation
 *  File: HelloServiceImpl.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: HelloServiceImpl.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Apr 16, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class HelloServiceImpl implements HelloService 
{

	public String sayHello(String msg)
	{
		if ("hello".equals(msg))
		{
			return "Hello world!";
		}
		else
		{
			return "Bye bye!";
		}
	}

}

/*
*$Log: av-env.bat,v $
*/