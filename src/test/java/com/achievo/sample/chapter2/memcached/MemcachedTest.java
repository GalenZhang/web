package com.achievo.sample.chapter2.memcached;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.schooner.MemCached.MemcachedItem;
import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: MemcachedTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: MemcachedTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Apr 20, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class MemcachedTest
{
	@Before
	public void init()
	{
		String[] servers = {"10.50.90.2:11211"};
		SockIOPool pool = SockIOPool.getInstance();
		pool.setServers(servers);
		pool.setFailback(true);
		pool.setInitConn(10);
		pool.setMinConn(5);
		pool.setMaxConn(25);pool.setMaintSleep(30);
		pool.setNagle(false);
		pool.setSocketTO(3000);
		pool.setAliveCheck(true);
		pool.setHashingAlg(SockIOPool.CONSISTENT_HASH);
		pool.initialize();
	}
	
	@Test
	public void testCacheData()
	{
		MemCachedClient memCachedClient = new MemCachedClient();
		memCachedClient.add("key", 1);
		memCachedClient.set("key", 2);
		memCachedClient.replace("key", 3);
		
		Object value = memCachedClient.get("key");
		System.out.println("value: " + value);
		String[] keys = {"key1", "key2"};
		Map<String, Object> values= memCachedClient.getMulti(keys);
		System.out.println("values: " + values);
		
		memCachedClient.set("key-name", " world");
		memCachedClient.prepend("key-name", "Hello");
		memCachedClient.append("key-name", "!");
		System.out.println("key-name: " + memCachedClient.get("key-name"));
		
		MemcachedItem item = memCachedClient.gets("key");
		memCachedClient.cas("key", (Integer)item.getValue() + 1, item.getCasUnique());
		System.out.println("key: " + value);
		
		memCachedClient.incr("key", 1);
		System.out.println("key: " + value);
		memCachedClient.decr("key", 1);
	}
}

/*
*$Log: av-env.bat,v $
*/