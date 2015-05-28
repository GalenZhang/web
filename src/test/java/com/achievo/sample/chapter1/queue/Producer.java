package com.achievo.sample.chapter1.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Producer.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Producer.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  May 28, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class Producer implements Runnable
{
	private volatile boolean isRunning = true;
	
	private BlockingQueue queue;
	
	private AtomicInteger count = new AtomicInteger();
	
	private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;
	
	public Producer(BlockingQueue queue)
	{
		this.queue = queue;
	}

	@Override
	public void run()
	{
		String data = null;
		Random r = new Random();
		System.out.println("启动生产者线程！");
		
		try
		{
			while (isRunning)
			{
				System.out.println("正在生产数据...");
				Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
				
				data = "data: " + count.incrementAndGet();
				System.out.println("将数据：" + data + "放入队列...");
				if (!queue.offer(data, 2, TimeUnit.SECONDS))
				{
					System.out.println("放入数据失败：" + data);
				}
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
            Thread.currentThread().interrupt();
		}
		finally
		{
			System.out.println("退出生产者线程！");
		}
	}
	
	public void stop()
	{
		isRunning = false;
	}

}

/*
*$Log: av-env.bat,v $
*/