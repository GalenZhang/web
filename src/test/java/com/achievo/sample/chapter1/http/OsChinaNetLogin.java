package com.achievo.sample.chapter1.http;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: OsChinaNetLogin.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: OsChinaNetLogin.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Apr 16, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class OsChinaNetLogin
{
	private HttpCompoentsUtil httpUtil = new HttpCompoentsUtil();

	/**
	 * 初始化url
	 */
	private String initCookieURL = "https://www.oschina.net/action/user/captcha";

	private String loginURL = "https://www.oschina.net/action/user/hash_login";

	/**
	 * @param args
	 * @throws
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		OsChinaNetLogin lession = new OsChinaNetLogin();

		lession.doQuery();
		lession.printCookies();
		lession.login();
		// 查看结果
		lession.doQuery();
	}

	public void printCookies()
	{
		httpUtil.printCookies();
	}

	public void initCookie()
	{
		System.out.println("---初始化Cookie---");
		httpUtil.get(initCookieURL, "UTF-8");
		httpUtil.printCookies();
	}

	public void login()
	{
		System.out.println("---登录---");
		Map<String, String> params = new HashMap<String, String>();
		params.put("email", "z60014840@163.com");
		// 密码有js加密过，大家可以先用一个错误的账号 输入正确的密码 找到加密后的 其他方式自行研究
		params.put("pwd", "********");
		params.put("verifyCode", "");
		params.put("save_login", "1");
		String result = httpUtil.post(loginURL, params);
		System.out.println(result);
		httpUtil.printCookies();
	}

	public void doQuery()
	{
		System.out.println("---查看当前登录信息---");
		String html = httpUtil.get("http://my.oschina.net/");
		System.out.println(html);
		Document doc = Jsoup.parse(html);
		String mySpace = doc.getElementById("OSC_Userbar").text();
		System.out.println(mySpace);
	}
}

/*
 * $Log: av-env.bat,v $
 */