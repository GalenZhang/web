package com.achievo.sample.chapter1.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: BlockingQueueTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  http://wsmajunfeng.iteye.com/blog/1629354  BlockingQueue
 * 
 *  Notes:
 * 	$Id: BlockingQueueTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  May 28, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class BlockingQueueTest
{
	@Test
	public void testLinkedBlockingQueue() throws InterruptedException
	{
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
		
		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Producer producer3 = new Producer(queue);
		
		Consumer consumer = new Consumer(queue);
		
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(producer1);
		service.execute(producer2);
		service.execute(producer3);
		service.execute(consumer);
		
		Thread.sleep(10*1000);
		producer1.stop();
		producer2.stop();
		producer3.stop();
		
		Thread.sleep(2000);
        // 退出Executor
        service.shutdown();
	}
}

/*
*$Log: av-env.bat,v $
*/