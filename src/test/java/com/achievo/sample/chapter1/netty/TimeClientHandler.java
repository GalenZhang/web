package com.achievo.sample.chapter1.netty;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: TimeClientHandler.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: TimeClientHandler.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class TimeClientHandler extends ChannelHandlerAdapter
{
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{
		UnixTime m = (UnixTime) msg;
		System.out.println(m);
		ctx.close();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
	{
		cause.printStackTrace();
		ctx.close();
	}
}

/*
 * $Log: av-env.bat,v $
 */