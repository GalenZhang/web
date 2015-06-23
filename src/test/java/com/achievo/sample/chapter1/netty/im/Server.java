package com.achievo.sample.chapter1.netty.im;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

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
 *  http://my.oschina.net/imhoodoo/blog/357290 TCP粘包/拆包问题的解决之道
 * 
 *  Notes:
 * 	$Id: Server.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Server
{
	public void bind(int port) throws Exception
	{
		// 接收客户端连接用
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		// 处理网络读写事件
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try
		{
			// 配置服务器启动类
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 100)
					.handler(new LoggingHandler(LogLevel.INFO)).childHandler(new ChannelInitializer<SocketChannel>()
					{
						@Override
						protected void initChannel(SocketChannel ch) throws Exception
						{
							ch.pipeline().addLast(new FixedLengthFrameDecoder(30)); // 设置定长解码器 长度设置为30
							ch.pipeline().addLast(new StringDecoder()); // 设置字符串解码器 自动将报文转为字符串
							ch.pipeline().addLast(new ServerHandler()); // 处理网络IO 处理器
						}
					});
			// 绑定端口 等待绑定成功
			ChannelFuture f = b.bind(port).sync();
			// 等待服务器退出
			f.channel().closeFuture().sync();
		}
		finally
		{
			// 释放线程资源
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception
	{
		int port = 9999;
		new Server().bind(port);
	}
}

/*
 * $Log: av-env.bat,v $
 */