package com.achievo.sample.chapter1.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Reactor.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  http://blog.csdn.net/linxcool/article/details/7771952  反应器(Reactor)模式
 * 
 *  Notes:
 * 	$Id: Reactor.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  May 27, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class Reactor implements Runnable
{
	public final Selector selector;
	public final ServerSocketChannel sreverSocketChannel;
	
	public Reactor(int port) throws IOException
	{
		selector = Selector.open();
		sreverSocketChannel = ServerSocketChannel.open();
		InetSocketAddress inetsocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), port);
		sreverSocketChannel.socket().bind(inetsocketAddress);
		sreverSocketChannel.configureBlocking(false);
		
		SelectionKey selectionKey = sreverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		selectionKey.attach(new Acceptor(this));
	}
	
	private void dispatch(SelectionKey key)
	{
		Runnable r = (Runnable)(key.attachment());
		if (r != null)
		{
			r.run();
		}
	}
	
	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				selector.select();
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> iter = selectionKeys.iterator();
				while (iter.hasNext())
				{
					SelectionKey selectionKey = iter.next();
					dispatch(selectionKey);
					selectionKeys.clear();
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}

/*
*$Log: av-env.bat,v $
*/