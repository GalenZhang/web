package com.achievo.sample.chapter1.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: HttpClientTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: HttpClientTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Apr 16, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class HttpClientTest
{
	@Test
	public void testGet()
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String url = "http://www.google.com";

		try
		{
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response = httpClient.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK)
			{
				HttpEntity entity = response.getEntity();
				String content = EntityUtils.toString(entity);
				System.out.println(content);

				response.close();
			}
		}
		catch (ClientProtocolException e)
		{
			e.printStackTrace();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				httpClient.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

	}
}

/*
 * $Log: av-env.bat,v $
 */