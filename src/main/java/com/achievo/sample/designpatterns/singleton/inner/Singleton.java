package com.achievo.sample.designpatterns.singleton.inner;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Singleton.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Singleton.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Singleton
{
	/* 私有构造方法，防止被实例化 */
	private Singleton()
	{
	}

	/* 此处使用一个内部类来维护单例 */
	private static class SingletonFactory
	{
		private static Singleton instance = new Singleton();
	}

	/* 获取实例 */
	public static Singleton getInstance()
	{
		return SingletonFactory.instance;
	}

	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
	public Object readResolve()
	{
		return getInstance();
	}
}

/*
 * $Log: av-env.bat,v $
 */