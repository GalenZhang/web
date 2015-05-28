package com.achievo.sample.chapter1.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Consumer.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Consumer.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  May 28, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Consumer implements Runnable
{
	private BlockingQueue<String> queue;

	private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

	public Consumer(BlockingQueue<String> queue)
	{
		this.queue = queue;
	}

	@Override
	public void run()
	{
		System.out.println("启动消费者线程！");
		Random r = new Random();
		boolean isRunning = true;

		try
		{
			while (isRunning)
			{
				System.out.println("正从队列获取数据...");
				String data = queue.poll(2, TimeUnit.SECONDS);
				if (data != null)
				{
					System.out.println("拿到数据：" + data);
					System.out.println("正在消费数据：" + data);
					Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
				}
				else
				{
					isRunning = false;
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
			System.out.println("退出消费者线程！");
		}
	}

}

/*
 * $Log: av-env.bat,v $
 */