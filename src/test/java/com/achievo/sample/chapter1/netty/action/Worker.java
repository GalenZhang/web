package com.achievo.sample.chapter1.netty.action;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Worker.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Worker.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 25, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Worker
{

	public void doWork()
	{
		Fetcher fetcher = new MyFetcher(new Data(1, 0));
		fetcher.fetchData(new FetcherCallback()
		{
			@Override
			public void onError(Throwable cause)
			{
				System.out.println("An error accour: " + cause.getMessage());
			}

			@Override
			public void onData(Data data)
			{
				System.out.println("Data received: " + data);
			}
		});
	}

	public static void main(String[] args)
	{
		Worker w = new Worker();
		w.doWork();
	}

}

/*
 * $Log: av-env.bat,v $
 */