package com.achievo.sample.designpatterns.bridge;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: MyBridge.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: MyBridge.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class MyBridge extends Bridge
{
	public void method()
	{
		getSource().method();
	}
}

/*
 * $Log: av-env.bat,v $
 */