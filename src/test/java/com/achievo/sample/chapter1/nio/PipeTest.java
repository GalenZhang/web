package com.achievo.sample.chapter1.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

import org.junit.Test;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: PipeTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: PipeTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  May 27, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class PipeTest
{
	@Test
	public void testPipe() throws IOException
	{
		Pipe pipe = Pipe.open();
		Pipe.SinkChannel sinkChannel = pipe.sink();
		
		String newData = "New String to write to file..." + System.currentTimeMillis();
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		buf.put(newData.getBytes());
		
		buf.flip();
		while (buf.hasRemaining())
		{
			sinkChannel.write(buf);
		}
		
		Pipe.SourceChannel sourceChannel = pipe.source();
		ByteBuffer bufSource = ByteBuffer.allocate(48);
		int bytesRead = sourceChannel.read(bufSource);
	}
}

/*
*$Log: av-env.bat,v $
*/