package com.achievo.sample.chapter1.netty.im;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: ClientHandler.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ClientHandler.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class ClientHandler extends ChannelHandlerAdapter
{
	private static final String MESSAGE = "Netty is a NIO client server framework which enables quick and easy development of network applications such as protocol servers and clients.";

	public ClientHandler()
	{
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception
	{
		ctx.writeAndFlush(Unpooled.copiedBuffer(MESSAGE.getBytes()));
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{
		System.out.println("接收服务器响应msg:[" + msg + "]");
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception
	{
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
	{
		cause.printStackTrace();
		ctx.close();
	}
}

/*
 * $Log: av-env.bat,v $
 */