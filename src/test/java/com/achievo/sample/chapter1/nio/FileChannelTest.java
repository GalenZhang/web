package com.achievo.sample.chapter1.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: FileChannelTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: FileChannelTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  May 26, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class FileChannelTest
{
	@Test
	public void testFileChannel() throws IOException
	{
		RandomAccessFile file = new RandomAccessFile("d:/1.txt", "rw");
		FileChannel channel = file.getChannel();
		
		ByteBuffer buf = ByteBuffer.allocate(48);
		int bytesRead = channel.read(buf);
		while (bytesRead != -1)
		{
			System.out.println("Read " + bytesRead);
			buf.flip();
			
			while (buf.hasRemaining())
			{
				System.out.println((char) buf.get());
			}
			
			buf.clear();
			bytesRead = channel.read(buf);
		}
		
		file.close();
	}
	
	@Test
	public void testFileChannel2() throws IOException
	{
		RandomAccessFile fromFile = new RandomAccessFile("d:/1.txt", "rw");
		FileChannel fromChannel = fromFile.getChannel();
		
		RandomAccessFile toFile = new RandomAccessFile("d:/2.txt", "rw");
		FileChannel toChannel = toFile.getChannel();
		
		long position = 0;
		long count = fromChannel.size();
		System.out.println("File size: " + count);
		toChannel.transferFrom(fromChannel, position, count);
		
		fromFile.close();
		toFile.close();
	}
	
	@Test
	public void testFileChannel3() throws IOException
	{
		RandomAccessFile fromFile = new RandomAccessFile("d:/1.txt", "rw");
		FileChannel fromChannel = fromFile.getChannel();
		
		RandomAccessFile toFile = new RandomAccessFile("d:/2.txt", "rw");
		FileChannel toChannel = toFile.getChannel();
		
		long position = 0;
		long count = fromChannel.size();
		System.out.println("File size: " + count);
		fromChannel.transferTo(position, count, toChannel);
		
		fromFile.close();
		toFile.close();
	}
	
	@Test
	public void testFileChannel4() throws IOException
	{
		RandomAccessFile file = new RandomAccessFile("d:/2.txt", "rw");
		FileChannel channel = file.getChannel();
		
		String newData = "New String to write to file..." + System.currentTimeMillis();
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		buf.put(newData.getBytes());
		
		buf.flip();
		while (buf.hasRemaining())
		{
			channel.write(buf);
		}
		
		file.close();
		channel.close();
	}
}

/*
*$Log: av-env.bat,v $
*/