package com.achievo.sample.designpatterns.observer;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Observer1.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Observer1.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Observer1 implements Observer
{

	@Override
	public void update()
	{
		System.out.println("observer1 has received!");
	}
}

/*
 * $Log: av-env.bat,v $
 */