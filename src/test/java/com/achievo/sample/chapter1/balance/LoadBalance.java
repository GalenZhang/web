package com.achievo.sample.chapter1.balance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: LoadBalance.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: LoadBalance.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 13, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class LoadBalance
{
	public static Integer pos = 0;

	public static Map<String, Integer> serverWeightMap = new HashMap<String, Integer>();

	static
	{
		serverWeightMap.put("192.168.1.100", 1);
		serverWeightMap.put("192.168.1.101", 1);
		serverWeightMap.put("192.168.1.102", 4);
		serverWeightMap.put("192.168.1.103", 1);
		serverWeightMap.put("192.168.1.104", 1);
		serverWeightMap.put("192.168.1.105", 3);
		serverWeightMap.put("192.168.1.106", 1);
		serverWeightMap.put("192.168.1.107", 2);
		serverWeightMap.put("192.168.1.108", 1);
		serverWeightMap.put("192.168.1.109", 1);
		serverWeightMap.put("192.168.1.110", 1);
	}

	// 轮询
	public static String testRoundRobin()
	{
		Map<String, Integer> serverMap = new HashMap<String, Integer>();
		serverMap.putAll(serverWeightMap);

		Set<String> keySet = serverMap.keySet();
		List<String> keyList = new ArrayList<String>();
		keyList.addAll(keySet);

		String server = null;

		synchronized (pos)
		{
			if (pos >= keySet.size())
			{
				pos = 0;
			}
			server = keyList.get(pos);
			pos++;
		}
		return server;
	}

	// 随机
	public static String testRandom()
	{
		Map<String, Integer> serverMap = new HashMap<String, Integer>();
		serverMap.putAll(serverWeightMap);

		Set<String> keySet = serverMap.keySet();
		List<String> keyList = new ArrayList<String>();
		keyList.addAll(keySet);

		Random random = new Random();
		int randomPos = random.nextInt(keyList.size());

		String server = keyList.get(randomPos);
		return server;
	}

	// 哈希
	public static String testConsumerHash(String remoteip)
	{
		Map<String, Integer> serverMap = new HashMap<String, Integer>();
		serverMap.putAll(serverWeightMap);

		Set<String> keySet = serverMap.keySet();
		List<String> keyList = new ArrayList<String>();
		keyList.addAll(keySet);

		int hashCode = remoteip.hashCode();
		int serverListSize = keyList.size();
		int serverPos = hashCode % serverListSize;

		return keyList.get(serverPos);
	}

	public static String testWeightRoundRobin()
	{
		Map<String, Integer> serverMap = new HashMap<String, Integer>();
		serverMap.putAll(serverWeightMap);

		Set<String> keySet = serverMap.keySet();
		Iterator<String> iter = keySet.iterator();
		List<String> serverList = new ArrayList<String>();

		while (iter.hasNext())
		{
			String server = iter.next();
			Integer weight = serverMap.get(server);
			for (int i = 0; i < weight; i++)
			{
				serverList.add(server);
			}
		}

		String server = null;

		synchronized (pos)
		{
			if (pos >= keySet.size())
			{
				pos = 0;
			}
			server = serverList.get(pos);
			pos++;
		}
		return server;
	}

	public static String testWeightRandom()
	{
		Map<String, Integer> serverMap = new HashMap<String, Integer>();
		serverMap.putAll(serverWeightMap);

		Set<String> keySet = serverMap.keySet();
		Iterator<String> iter = keySet.iterator();
		List<String> serverList = new ArrayList<String>();

		while (iter.hasNext())
		{
			String server = iter.next();
			Integer weight = serverMap.get(server);
			for (int i = 0; i < weight; i++)
			{
				serverList.add(server);
			}
		}

		Random random = new Random();
		int randomPos = random.nextInt(serverList.size());

		String server = serverList.get(randomPos);
		return server;
	}
}

/*
 * $Log: av-env.bat,v $
 */