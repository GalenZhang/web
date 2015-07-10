package com.achievo.sample.designpatterns.memento;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Storage.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Storage.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Storage
{
	private Memento memento;

	public Storage(Memento memento)
	{
		this.memento = memento;
	}

	public Memento getMemento()
	{
		return memento;
	}

	public void setMemento(Memento memento)
	{
		this.memento = memento;
	}
}

/*
 * $Log: av-env.bat,v $
 */