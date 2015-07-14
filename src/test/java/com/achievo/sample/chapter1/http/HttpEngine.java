package com.achievo.sample.chapter1.http;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: HttpEngine.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  http://www.anthonylee.cn/?p=40
 * 
 *  Notes:
 * 	$Id: HttpEngine.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 13, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class HttpEngine
{
	private CloseableHttpClient httpClient = null;

	/******** 单例模式声明开始 ********************/
	// 类初始化时，自行实例化，饿汉式单例模式
	private static final HttpEngine httpEngine = new HttpEngine();

	public static HttpEngine getHttpEngineInstance()
	{
		return httpEngine;
	}

	private HttpEngine()
	{
		initHttpClient();
	}

	private void initHttpClient()
	{
		// 创建httpclient连接池
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(200); // 设置连接池线程最大数量
		cm.setDefaultMaxPerRoute(100); // 设置单个路由最大的连接线程数量
		// 创建http request的配置信息
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(Constant.REQUEST_TIMEOUT)
				.setConnectTimeout(Constant.REQUEST_TIMEOUT).setSocketTimeout(Constant.REQUEST_SOCKET_TIME).build();
		// 设置重定向策略
		// LaxRedirectStrategy redirectStrategy = new LaxRedirectStrategy();
		// 初始化httpclient客户端
		httpClient = HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(requestConfig).build();
	}

	public String execute(String url)
	{
		String result = "";
		if (null == url || "".equals(url))
		{
			result = "";
			// 如果url为空或者null，则返回src空值ֵ
		}
		else
		{
			// 创建httpclient请求方式
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response = null;
			try
			{
				response = makeRequestWithRetries(httpGet);
				result = parseResponse2String(response);
			}
			catch (IOException e)
			{
				// log
			}
			finally
			{
				if (null != response)
				{
					try
					{
						// 关闭response
						response.close();
						httpGet.abort();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		return result;
	}

	public CloseableHttpResponse execute(HttpUriRequest request) throws IOException
	{
		CloseableHttpResponse response = null;
		if (null == request)
		{
			response = null;
			// 如果httpPost为空或者null，则返回空
		}
		else
		{
			// 创建httpclient请求方式
			response = makeRequestWithRetries(request);
		}
		return response;
	}

	// 抛异常重试三次
	private CloseableHttpResponse makeRequestWithRetries(HttpUriRequest request)
	{
		CloseableHttpResponse response = null;
		int retryCount = 0;
		while (retryCount++ < Constant.HTTP_MAX_RETRIES)
		{
			try
			{
				return response = httpClient.execute(request);
			}
			catch (ClientProtocolException e)
			{
				System.out.println("RETRIES again " + retryCount + " in makeRequestWithRetries<request>: "
						+ e.getMessage());
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("RETRIES again " + retryCount + " in makeRequestWithRetries<request>: "
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		return response;
	}

	public static String parseResponse2String(HttpResponse response) throws IOException
	{

		String responseBody = "";

		HttpEntity entity = null;
		HttpEntity temp = response.getEntity();
		if (temp != null)
		{
			entity = new BufferedHttpEntity(temp);
			responseBody = EntityUtils.toString(entity);
		}

		return responseBody;

	}

	public static void main(String args[]) throws IOException, ParseException
	{
		// 使用方式1
		HttpEngine httpEngine = HttpEngine.getHttpEngineInstance();
		String result = httpEngine.execute("http://www.baidu.com?param1=sfdsfsdfs&param2=9897979789789");
		System.out.println(result);

		// 使用方法2
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("param1", "sfdsfsdfs"));
		formparams.add(new BasicNameValuePair("param2", "9897979789789"));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httpPost = new HttpPost("www.baidu.com");
		httpPost.setEntity(entity);
		CloseableHttpResponse response = httpEngine.execute(httpPost);
		result = parseResponse2String(response);
		response.close();
		System.out.println(result);

	}

}

/*
 * $Log: av-env.bat,v $
 */