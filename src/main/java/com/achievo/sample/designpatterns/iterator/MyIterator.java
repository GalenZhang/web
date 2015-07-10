package com.achievo.sample.designpatterns.iterator;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: MyIterator.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: MyIterator.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class MyIterator implements Iterator
{

	private Collection collection;

	private int pos = -1;

	public MyIterator(Collection collection)
	{
		this.collection = collection;
	}

	@Override
	public Object previous()
	{
		if (pos > 0)
		{
			pos--;
		}
		return collection.get(pos);
	}

	@Override
	public Object next()
	{
		if (pos < collection.size() - 1)
		{
			pos++;
		}
		return collection.get(pos);
	}

	@Override
	public boolean hasNext()
	{
		if (pos < collection.size() - 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Object first()
	{
		pos = 0;
		return collection.get(pos);
	}

}

/*
 * $Log: av-env.bat,v $
 */