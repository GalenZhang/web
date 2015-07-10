package com.achievo.sample.designpatterns.memento;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Original.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Original.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Original
{
	private String value;

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public Original(String value)
	{
		this.value = value;
	}

	public Memento createMemento()
	{
		return new Memento(value);
	}

	public void restoreMemento(Memento memento)
	{
		this.value = memento.getValue();
	}
}

/*
 * $Log: av-env.bat,v $
 */