package com.achievo.sample.chapter1.netty.time;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: TimeServer.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  http://my.oschina.net/imhoodoo/blog/357007 Netty5入门学习笔记001
 * 
 *  Notes:
 * 	$Id: TimeServer.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class TimeServer
{
	public void bind(int port) throws Exception
	{
		// 服务器线程组 用于网络事件的处理 一个用于服务器接收客户端的连接
		// 另一个线程组用于处理SocketChannel的网络读写
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try
		{
			// NIO服务器端的辅助启动类 降低服务器开发难度
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)// 类似NIO中serverSocketChannel
					.option(ChannelOption.SO_BACKLOG, 1024)// 配置TCP参数
					.childHandler(new ChannelInitializer<SocketChannel>()
					{

						@Override
						protected void initChannel(SocketChannel ch) throws Exception
						{
							ch.pipeline().addLast(new TimeServerHandler());
						}

					});// 最后绑定I/O事件的处理类

			// 服务器启动后 绑定监听端口 同步等待成功 主要用于异步操作的通知回调 回调处理用的ChildChannelHandler
			ChannelFuture f = serverBootstrap.bind(port).sync();
			System.out.println("timeServer启动");
			// 等待服务端监听端口关闭
			f.channel().closeFuture().sync();
		}
		finally
		{
			// 优雅退出 释放线程池资源
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
			System.out.println("服务器优雅的释放了线程资源...");
		}
	}

	public static void main(String[] args) throws Exception
	{
		int port = 9999;
		new TimeServer().bind(port);
	}
}

/*
 * $Log: av-env.bat,v $
 */