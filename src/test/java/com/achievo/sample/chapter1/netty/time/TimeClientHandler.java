package com.achievo.sample.chapter1.netty.time;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import org.apache.log4j.Logger;

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
	private static final Logger logger = Logger.getLogger(TimeClientHandler.class.getName());

	private ByteBuf firstMessage;

	public TimeClientHandler()
	{
		byte[] req = "QUERY TIME ORDER".getBytes();
		firstMessage = Unpooled.buffer(req.length);
		firstMessage.writeBytes(req);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception
	{
		ctx.writeAndFlush(firstMessage);
		System.out.println("客户端active");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{
		System.out.println("客户端收到服务器响应数据");
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "UTF-8");
		System.out.println("Now is:" + body);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception
	{
		ctx.flush();
		System.out.println("客户端收到服务器响应数据处理完成");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
	{
		logger.warn("Unexpected exception from downstream:" + cause.getMessage());
		ctx.close();
		System.out.println("客户端异常退出");
	}
}

/*
 * $Log: av-env.bat,v $
 */