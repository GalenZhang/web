package com.achievo.sample.designpatterns.observer;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: ObserverTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ObserverTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class ObserverTest
{
	public static void main(String[] args)
	{
		Subject sub = new MySubject();
		sub.add(new Observer1());
		sub.add(new Observer2());

		sub.operation();
	}
}

/*
 * $Log: av-env.bat,v $
 */