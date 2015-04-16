package com.achievo.sample.chapter1.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Client.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Client.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Apr 16, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class Client
{
	@Test
	public void testSend() throws UnknownHostException, IOException
	{
		Request request = new Request();
		request.setCommand("HELLO");
		request.setCommandLength(request.getCommand().length());
		request.setEncode(Encode.UTF8.ordinal());
		
		Socket client = new Socket("127.0.0.1", 4567);
		OutputStream output = client.getOutputStream();
		
		ProtocolUtil.writeRequest(output, request);
		
		InputStream input = client.getInputStream();
		Response response = ProtocolUtil.readResponse(input);
		System.out.println(response.getResponse());
	}
	
	@Test
	public void testByteUtil()
	{
		int i = 5;
		byte[] bytes = ByteUtil.int2ByteArray(i);
		int result = ByteUtil.bytes2Int(bytes);
		System.out.println(result);
	}
}

/*
*$Log: av-env.bat,v $
*/