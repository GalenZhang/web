package com.achievo.sample.chapter1.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: DiscardServerHandler.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: DiscardServerHandler.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 17, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class DiscardServerHandler extends ChannelHandlerAdapter
{
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{
//		((ByteBuf) msg).release();
		ByteBuf in = (ByteBuf) msg;

		try
		{
			while (in.isReadable())
			{
				System.out.print((char) in.readByte());
				System.out.flush();
			}
		}
		finally
		{
			ReferenceCountUtil.release(msg);
		}
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