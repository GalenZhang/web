package com.achievo.sample.designpatterns.iterator;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: MyCollection.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: MyCollection.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class MyCollection implements Collection
{

	public String string[] = {"A", "B", "C", "D", "E"};

	@Override
	public Iterator iterator()
	{
		return new MyIterator(this);
	}

	@Override
	public Object get(int i)
	{
		return string[i];
	}

	@Override
	public int size()
	{
		return string.length;
	}
}

/*
 * $Log: av-env.bat,v $
 */