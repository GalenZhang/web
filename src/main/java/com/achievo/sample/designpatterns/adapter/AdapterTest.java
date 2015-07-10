package com.achievo.sample.designpatterns.adapter;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: AdapterTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: AdapterTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class AdapterTest
{
	public static void main(String[] args)
	{
		Targetable target = new Adapter();
		target.method1();
		target.method2();
	}
}

/*
 * $Log: av-env.bat,v $
 */