package com.achievo.sample.designpatterns.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: AbstractSubject.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: AbstractSubject.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public abstract class AbstractSubject implements Subject
{

	private Vector<Observer> vector = new Vector<Observer>();

	@Override
	public void add(Observer observer)
	{
		vector.add(observer);
	}

	@Override
	public void del(Observer observer)
	{
		vector.remove(observer);
	}

	@Override
	public void notifyObservers()
	{
		Enumeration<Observer> enumo = vector.elements();
		while (enumo.hasMoreElements())
		{
			enumo.nextElement().update();
		}
	}
}

/*
 * $Log: av-env.bat,v $
 */