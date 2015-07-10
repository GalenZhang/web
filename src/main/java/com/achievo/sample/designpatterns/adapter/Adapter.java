package com.achievo.sample.designpatterns.adapter;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Adapter.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Adapter.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Adapter extends Source implements Targetable
{

	@Override
	public void method2()
	{
		System.out.println("this is the targetable method!");
	}
}

/*
 * $Log: av-env.bat,v $
 */