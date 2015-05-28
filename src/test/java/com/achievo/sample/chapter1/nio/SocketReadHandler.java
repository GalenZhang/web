package com.achievo.sample.chapter1.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: SocketReadHandler.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: SocketReadHandler.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  May 27, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class SocketReadHandler implements Runnable
{
	private SocketChannel socketChannel;
	
	public SocketReadHandler(Selector selector, SocketChannel socketChannel) throws IOException
	{
		this.socketChannel = socketChannel;
		socketChannel.configureBlocking(false);
		
		SelectionKey selectionKey = socketChannel.register(selector, 0);
		selectionKey.attach(this);
		
		selectionKey.interestOps(SelectionKey.OP_READ);
		selector.wakeup();
	}
	
	@Override
	public void run()
	{
		ByteBuffer buf = ByteBuffer.allocate(1024);
		buf.clear();
		try
		{
			socketChannel.read(buf);
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