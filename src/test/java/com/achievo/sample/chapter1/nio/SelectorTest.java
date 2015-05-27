package com.achievo.sample.chapter1.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: SelectorTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: SelectorTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  May 26, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class SelectorTest
{
	@Test
	public void testSelector() throws IOException
	{
		Selector selector = Selector.open();
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));

		
		socketChannel.configureBlocking(false);
		SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
//		selectionKey.channel();
		
		while (true) {
			int readyChannels = selector.select();
			if (readyChannels == 0) continue;
			
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
			while (keyIterator.hasNext())
			{
				SelectionKey key = keyIterator.next();
				if (key.isAcceptable()) {
					
				} else if (key.isConnectable()) {
					
				} else if (key.isReadable()) {
					
				} else if (key.isWritable()) {
					
				}
				keyIterator.remove();
			}
		}
		
	}
}

/*
*$Log: av-env.bat,v $
*/