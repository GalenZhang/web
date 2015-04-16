package com.achievo.sample.chapter1.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Server.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Server.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Apr 16, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class Server
{
	@Test
	public void testReceive() throws IOException
	{
		ServerSocket server = new ServerSocket(4567);
		while (true)
		{
			Socket client = server.accept();
			InputStream input = client.getInputStream();
			Request request = ProtocolUtil.readRequest(input);
			
			OutputStream output = client.getOutputStream();
			Response response = new Response();
			response.setEncode(Encode.UTF8.ordinal());
			
			if (request.getCommand().equals("HELLO"))
			{
				response.setResponse("Hello world!");
			}
			else
			{
				response.setResponse("Bye bye!");
			}
			response.setResponseLength(response.getResponse().length());
			
			ProtocolUtil.writeResponse(output, response);
			break;
		}
	}
}

/*
*$Log: av-env.bat,v $
*/