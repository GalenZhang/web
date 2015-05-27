package com.achievo.sample.chapter1.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

import org.junit.Test;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: DatagramChannelTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: DatagramChannelTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  May 26, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class DatagramChannelTest
{
	@Test
	public void testDatagramChannel() throws IOException
	{
		DatagramChannel channel = DatagramChannel.open();
		channel.socket().bind(new InetSocketAddress(9999));
		
//		ByteBuffer buf = ByteBuffer.allocate(48);
//		buf.clear();
//		channel.receive(buf);
		
		String newData = "New String to write to file..." + System.currentTimeMillis();
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		buf.put(newData.getBytes());
		buf.flip();
		
		int bytesSent = channel.send(buf, new InetSocketAddress("jenkov.com", 80));
		channel.connect(new InetSocketAddress("jenkov.com", 80));
		int bytesRead = channel.read(buf);
		int bytesWritten = channel.write(buf);
	}
}

/*
*$Log: av-env.bat,v $
*/