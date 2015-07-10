package com.achievo.sample.designpatterns.singleton;

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
	/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
	private static Singleton instance = null;

	/* 私有构造方法，防止被实例化 */
	private Singleton()
	{
	}

	/* 静态工程方法，创建实例 */
	public static Singleton getInstance()
	{
		if (instance == null)
		{
			synchronized (instance)
			{
				if (instance == null)
				{
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
	public Object readResolve()
	{
		return instance;
	}
}

/*
 * $Log: av-env.bat,v $
 */