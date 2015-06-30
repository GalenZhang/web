package com.achievo.sample.chapter1.netty.action;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: FetcherCallback.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: FetcherCallback.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 25, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public interface FetcherCallback
{
	void onData(Data data) throws Exception;

	void onError(Throwable cause);
}

/*
 * $Log: av-env.bat,v $
 */