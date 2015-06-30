package com.achievo.sample.chapter1.netty.action;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Data.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Data.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 25, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Data
{

	private int n;

	private int m;

	public Data(int n, int m)
	{
		this.n = n;
		this.m = m;
	}

	@Override
	public String toString()
	{
		int r = n / m;
		return n + "/" + m + " = " + r;
	}
}

/*
 * $Log: av-env.bat,v $
 */