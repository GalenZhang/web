package com.achievo.sample.chapter1.http;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Mail163Login.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Mail163Login.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Apr 16, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Mail163Login
{
	private HttpCompoentsUtil httpUtil = new HttpCompoentsUtil();

	private String loginURL = "https://ssl.mail.163.com/entry/coremail/fcg/ntesdoor2";

	private String sid;

	private String mailBox = "http://cwebmail.mail.163.com/js5/s?func=mbox:listMessages&from=nav&group=folder&id=1&action=click&mboxentry=1&sid=";

	public static void main(String[] args)
	{
		Mail163Login lession = new Mail163Login();
		lession.login();
		lession.mailBox();
	}

	private void mailBox()
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put(
			"var",
			"<?xml version=\"1.0\"?><object><int name=\"fid\">1</int><boolean name=\"skipLockedFolders\">false</boolean><string name=\"order\">date</string><boolean name=\"desc\">true</boolean><int name=\"start\">0</int><int name=\"limit\">50</int><boolean name=\"topFirst\">true</boolean><boolean name=\"returnTotal\">true</boolean><boolean name=\"returnTag\">true</boolean></object>");
		String result = httpUtil.post(mailBox + sid, params);
		System.out.println(result);
	}

	private void login()
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("ds", "mail163_letter");
		params.put("from", "web");
		params.put("funcid", "loginone");
		params.put("iframe", "1");
		params.put("language", "-1");
		params.put("passtype", "1");
		params.put("product", "mail163");
		params.put("net", "c");
		params.put("stype", "-1");
		params.put("race", "167_158_146_gz");
		params.put("uid", "osLoadLession@163.com");
		params.put("savelogin", "0");
		params.put("url2", "http://mail.163.com/errorpage/error163.htm");
		params.put("username", "osLoadLession");
		params.put("password", "bangis123456");

		String s = httpUtil.post(loginURL, params).trim();
		System.out.println(s);
		int i = s.indexOf("http://mail.163.com/");
		if (i == -1)
		{
			i = s.indexOf("http://hwwebmail.mail.163.com/");
		}
		String mainUrl = s.substring(i, s.indexOf("\";</script>"));
		httpUtil.get(mainUrl);
		sid = httpUtil.getCookie("Coremail.sid");
		System.out.println("==============sid:" + sid);
		httpUtil.printCookies();
	}
}

/*
 * $Log: av-env.bat,v $
 */