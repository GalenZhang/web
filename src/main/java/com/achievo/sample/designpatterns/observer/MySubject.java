package com.achievo.sample.designpatterns.observer;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: MySubject.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: MySubject.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class MySubject extends AbstractSubject
{

	@Override
	public void operation()
	{
		System.out.println("update self!");
		notifyObservers();
	}

}

/*
 * $Log: av-env.bat,v $
 */