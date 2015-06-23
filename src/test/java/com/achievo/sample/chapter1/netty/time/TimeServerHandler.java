package com.achievo.sample.chapter1.netty.time;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: TimeServerHandler.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: TimeServerHandler.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class TimeServerHandler extends ChannelHandlerAdapter
{
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{
		System.out.println("服务器读取到客户端请求...");
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "UTF-8");
		System.out.println("the time server receive order:" + body);
		String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis())
				.toString() : "BAD ORDER";
		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
		ctx.write(resp);
		System.out.println("服务器做出了响应");
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception
	{
		ctx.flush();
		System.out.println("服务器readComplete 响应完成");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
	{
		ctx.close();
		System.out.println("服务器异常退出" + cause.getMessage());
	}
}

/*
 * $Log: av-env.bat,v $
 */