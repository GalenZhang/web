package com.achievo.sample.chapter1.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import org.junit.Test;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: SocketChannelTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: SocketChannelTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  May 26, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class SocketChannelTest
{
	@Test
	public void testSocketChannel() throws IOException
	{
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));
//		ByteBuffer buf = ByteBuffer.allocate(48);
//		int bytesRead = socketChannel.read(buf);
		
//		socketChannel.configureBlocking(false);
//		while (!socketChannel.finishConnect())
//		{
//			//wait, or do something else...
//		}
		
		String newData = "New String to write to file..." + System.currentTimeMillis();
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		buf.put(newData.getBytes());
		
		buf.flip();
		while (buf.hasRemaining())
		{
			socketChannel.write(buf);
		}
		
		socketChannel.close();
	}
}

/*
*$Log: av-env.bat,v $
*/