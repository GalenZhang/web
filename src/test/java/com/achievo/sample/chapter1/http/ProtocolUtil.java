package com.achievo.sample.chapter1.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * <pre>
 * 
 *  Accela Automation
 *  File: ProtocolUtil.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ProtocolUtil.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Apr 16, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class ProtocolUtil
{
	public static Request readRequest(InputStream input) throws IOException
	{
		byte[] encodeByte = new byte[1];
		input.read(encodeByte);
		byte encode = encodeByte[0];
		
		byte[] commandLengthBytes = new byte[4];
		input.read(commandLengthBytes);
		int commandLength = ByteUtil.bytes2Int(commandLengthBytes);;
		
		byte[] commandBytes = new byte[commandLength];
		input.read(commandBytes);
		String command = "";
		if (Encode.GBK.ordinal() == encode)
		{
			command = new String(commandBytes, "GBK");
		}
		else
		{
			command = new String(commandBytes, "UTF8");
		}
		
		Request request = new Request();
		request.setCommand(command);
		request.setEncode(encode);
		request.setCommandLength(commandLength);
		
		return request;
	}
	
	public static Response readResponse(InputStream input) throws IOException
	{
		byte[] encodeByte = new byte[1];
		input.read(encodeByte);
		byte encode = encodeByte[0];
		
		byte[] responseLengthBytes = new byte[4];
		input.read(responseLengthBytes);
		int responseLength = ByteUtil.bytes2Int(responseLengthBytes);;
		
		byte[] responseBytes = new byte[responseLength];
		input.read(responseBytes);
		String responseStr = "";
		if (Encode.GBK.ordinal() == encode)
		{
			responseStr = new String(responseBytes, "GBK");
		}
		else
		{
			responseStr = new String(responseBytes, "UTF8");
		}
		
		Response response = new Response();
		response.setEncode(encode);
		response.setResponseLength(responseLength);
		response.setResponse(responseStr);
		
		return response;
	}
	
	public static void writeRequest(OutputStream output, Request request) throws IOException
	{
		output.write(request.getEncode());
		output.write(ByteUtil.int2ByteArray(request.getCommandLength()));
		if (Encode.GBK.ordinal() == request.getEncode())
		{
			output.write(request.getCommand().getBytes("GBK"));
		}
		else
		{
			output.write(request.getCommand().getBytes("UTF8"));
		}
		
		output.flush();
	}
	
	public static void writeResponse(OutputStream output, Response response) throws IOException
	{
		output.write(response.getEncode());
		output.write(ByteUtil.int2ByteArray(response.getResponseLength()));
		if (Encode.GBK.ordinal() == response.getEncode())
		{
			output.write(response.getResponse().getBytes("GBK"));
		}
		else
		{
			output.write(response.getResponse().getBytes("UTF8"));
		}
		
		output.flush();
	}
}

/*
*$Log: av-env.bat,v $
*/