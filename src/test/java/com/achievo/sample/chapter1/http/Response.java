package com.achievo.sample.chapter1.http;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Respnose.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Respnose.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Apr 16, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Response
{
	private int encode;

	private int responseLength;

	private String response;

	public int getEncode()
	{
		return encode;
	}

	public void setEncode(int encode)
	{
		this.encode = encode;
	}

	public int getResponseLength()
	{
		return responseLength;
	}

	public void setResponseLength(int responseLength)
	{
		this.responseLength = responseLength;
	}

	public String getResponse()
	{
		return response;
	}

	public void setResponse(String response)
	{
		this.response = response;
	}

}

/*
 * $Log: av-env.bat,v $
 */