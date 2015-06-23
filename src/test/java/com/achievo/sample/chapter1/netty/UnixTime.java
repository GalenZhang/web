package com.achievo.sample.chapter1.netty;

import java.util.Date;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: UnixTime.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: UnixTime.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class UnixTime
{
	private final int value;

	public UnixTime()
	{
		this((int) (System.currentTimeMillis() / 1000L + 2208988800L));
	}

	public UnixTime(int value)
	{
		this.value = value;
	}

	public int value()
	{
		return value;
	}

	@Override
	public String toString()
	{
		return new Date((value() - 2208988800L) * 1000L).toString();
	}
}

/*
 * $Log: av-env.bat,v $
 */