package com.achievo.sample.chapter1.thread.queue;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: ConcurrentLinkedQueueTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ConcurrentLinkedQueueTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 26, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class ConcurrentLinkedQueueTest
{
	private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();

	private static int count = 2; // 线程个数

	// CountDownLatch，一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
	private static CountDownLatch latch = new CountDownLatch(count);

	public static void main(String[] args) throws InterruptedException
	{
		long timeStart = System.currentTimeMillis();
		ExecutorService es = Executors.newFixedThreadPool(4);
		ConcurrentLinkedQueueTest.offer();
		for (int i = 0; i < count; i++)
		{
			es.submit(new Poll());
		}
		latch.await(); // 使得主线程(main)阻塞直到latch.countDown()为零才继续执行
		System.out.println("cost time " + (System.currentTimeMillis() - timeStart) + "ms");
		es.shutdown();
	}

	/**
	 * 生产
	 */
	public static void offer()
	{
		for (int i = 0; i < 100000; i++)
		{
			queue.offer(i);
		}
	}

	/**
	 * 消费
	 * 
	 * @author 林计钦
	 * @version 1.0 2013-7-25 下午05:32:56
	 */
	static class Poll implements Runnable
	{
		public void run()
		{
			// while (queue.size()>0) {
			while (!queue.isEmpty())
			{
				System.out.println(queue.poll());
			}
			latch.countDown();
		}
	}
}

/*
 * $Log: av-env.bat,v $
 */