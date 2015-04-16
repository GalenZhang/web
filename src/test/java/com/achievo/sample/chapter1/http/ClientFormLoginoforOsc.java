package com.achievo.sample.chapter1.http;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: ClientFormLoginoforOsc.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ClientFormLoginoforOsc.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jan 24, 2014		galen.zhang		Initial.
 * 
 * </pre>
 */
public class ClientFormLoginoforOsc
{

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception
	{

		String url = "http://www.oschina.net/news/27955/google-stock";

//		CloseableHttpClient httpClient = HttpClients.createDefault();
		BasicCookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();
		try
		{
			HttpGet httpget = new HttpGet("https://www.oschina.net/home/login");

			HttpResponse response = httpClient.execute(httpget);
			HttpEntity entity = response.getEntity();

			System.out.println("Login form get: " + response.getStatusLine());
			EntityUtils.consume(entity);

			System.out.println("Initial set of cookies:");
			List<Cookie> cookies = cookieStore.getCookies();
			if (cookies.isEmpty())
			{
				System.out.println("None");
			}
			else
			{
				for (int i = 0; i < cookies.size(); i++)
				{
					System.out.println("- " + cookies.get(i).toString());
				}
			}

			// Cookie 登录之后记录
			String tmpcookies = "";
			HttpPost httpost = new HttpPost("https://www.oschina.net/action/user/login");

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("email", "z60014840@163.com"));
			nvps.add(new BasicNameValuePair("pwd", "********"));

			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

			response = httpClient.execute(httpost);
			entity = response.getEntity();

			System.out.println("Login form post: " + response.getStatusLine());
			EntityUtils.consume(entity);

			System.out.println("Post logon cookies:");
			cookies = cookieStore.getCookies();
			if (cookies.isEmpty())
			{
				System.out.println("None");
			}
			else
			{
				for (int i = 0; i < cookies.size(); i++)
				{
					System.out.println("- " + cookies.get(i).toString());
					tmpcookies += cookies.get(i).toString();
				}
			}
			// 登录之后进行操作
			HttpGet httpget1 = new HttpGet(url);
			// 设置cookie,登录后操作
			httpget1.setHeader("cookie", tmpcookies);

			HttpResponse response1 = httpClient.execute(httpget1);
			HttpEntity entity1 = response1.getEntity();

			System.out.println("Login form find: " + response.getStatusLine());

			System.out.println("Initial set of cookies:");
			List<Cookie> cookies1 = cookieStore.getCookies();
			if (cookies1.isEmpty())
			{
				System.out.println("None");
			}
			else
			{
				for (int i = 0; i < cookies1.size(); i++)
				{
					System.out.println("- " + cookies1.get(i).toString());
				}
			}
			if (entity1 != null)
			{
				// 读取内容
				System.out.println(entity1.getContentLength());
				System.out.println(EntityUtils.toString(entity1));
//				BufferedReader reader = new BufferedReader(new InputStreamReader(entity1.getContent(), "utf-8"));
//				try
//				{
//
//					String str = null;
//					while ((str = reader.readLine()) != null)
//					{
//						System.out.println(str);
//					}
//				}
//				catch (IOException ex)
//				{
//					throw ex;
//				}
//				catch (RuntimeException ex)
//				{
//					throw ex;
//				}
//				finally
//				{
//					reader.close();
//				}
			}
			EntityUtils.consume(entity1);

		}
		finally
		{
			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			httpClient.getConnectionManager().shutdown();
		}
	}
}

/*
 * $Log: av-env.bat,v $
 */