package com.achievo.sample.designpatterns.adapter;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: AdapterTest1.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: AdapterTest1.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class AdapterTest1
{
	public static void main(String[] args)
	{
		Source source = new Source();
		Targetable target = new Wrapper(source);
		target.method1();
		target.method2();
	}
}

/*
 * $Log: av-env.bat,v $
 */