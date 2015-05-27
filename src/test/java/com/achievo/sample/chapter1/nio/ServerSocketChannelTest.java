package com.achievo.sample.chapter1.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: ServerSocketChannelTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ServerSocketChannelTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  May 26, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class ServerSocketChannelTest
{
	public void testServerSocketChannel() throws IOException
	{
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(9999));
		serverSocketChannel.configureBlocking(false);
		
		while (true)
		{
			SocketChannel socketChannel = serverSocketChannel.accept();
			if (socketChannel != null)
			{
				//do something with socketChannel...
			}
			break;
		}
		
		serverSocketChannel.close();

	}
}

/*
*$Log: av-env.bat,v $
*/