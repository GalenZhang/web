package com.achievo.sample.chapter1.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

import org.junit.Test;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: WeakHashMapTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  http://www.cnblogs.com/jisheng/archive/2011/12/02/2271862.html WeakHashMap
 * 
 *  Notes:
 * 	$Id: WeakHashMapTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  May 29, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class WeakHashMapTest
{
	@Test
	public void testWeakHashMap()
	{
		String a = new String("a");
		String b = new String("b");
		Map weakHashMap = new WeakHashMap();
		Map map = new HashMap();
		map.put(a, "aaa");
		map.put(b, "bbb");

		weakHashMap.put(a, "aaa");
		weakHashMap.put(b, "bbb");

		map.remove(a);

		a = null;
		b = null;

		System.gc();
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext())
		{
			Map.Entry en = (Map.Entry) iter.next();
			System.out.println("map: " + en.getKey() + " : " + en.getValue());
		}

		Iterator iter1 = weakHashMap.entrySet().iterator();
		while (iter1.hasNext())
		{
			Map.Entry en = (Map.Entry) iter1.next();
			System.out.println("weakHashMap: " + en.getKey() + " : " + en.getValue());
		}
	}

	@Test
	public void testWeakHashMap1()
	{
		Map map = new WeakHashMap();
		map.put("1", "test data");
		map.put(5, "data 5");
		System.out.println(map.get("1"));
		System.out.println(map.get(5));

		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("next get:" + map.get(5));
	}
}

/*
 * $Log: av-env.bat,v $
 */