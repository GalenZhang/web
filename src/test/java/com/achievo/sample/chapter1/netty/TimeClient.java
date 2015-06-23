package com.achievo.sample.chapter1.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: TimeClient.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: TimeClient.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class TimeClient
{

	public static void main(String[] args) throws Exception
	{
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try
		{
			Bootstrap b = new Bootstrap();
			b.group(workerGroup);
			b.channel(NioSocketChannel.class);
			b.option(ChannelOption.SO_KEEPALIVE, true);
			b.handler(new ChannelInitializer<SocketChannel>()
			{

				@Override
				protected void initChannel(SocketChannel ch) throws Exception
				{
					ch.pipeline().addLast(new TimeDecoder(), new TimeClientHandler());
				}
			});

			ChannelFuture f = b.connect(host, port).sync();
			f.channel().closeFuture().sync();
		}
		finally
		{
			workerGroup.shutdownGracefully();
		}
	}

}

/*
 * $Log: av-env.bat,v $
 */