package com.achievo.sample.chapter1.netty;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: EchoServerHandler.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EchoServerHandler.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class EchoServerHandler extends ChannelHandlerAdapter
{
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{
		ctx.write(msg);
		ctx.flush();
//		ctx.writeAndFlush(msg);
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