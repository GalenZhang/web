package com.achievo.sample.chapter1.netty.action;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: MyFetcher.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: MyFetcher.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 25, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class MyFetcher implements Fetcher
{

	final Data data;

	public MyFetcher(Data data)
	{
		this.data = data;
	}

	@Override
	public void fetchData(FetcherCallback callback)
	{
		try
		{
			callback.onData(data);
		}
		catch (Exception e)
		{
			callback.onError(e);
		}
	}

}

/*
 * $Log: av-env.bat,v $
 */