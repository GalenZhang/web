package com.achievo.sample.chapter1.netty.im;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Client.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Client.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Client
{
	public void connect(int port, String host) throws Exception
	{
		// 网络事件处理线程组
		EventLoopGroup group = new NioEventLoopGroup();
		try
		{
			// 配置客户端启动类
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true) // 设置封包
																									// 使用一次大数据的写操作，而不是多次小数据的写操作
					.handler(new ChannelInitializer<SocketChannel>()
					{
						@Override
						protected void initChannel(SocketChannel ch) throws Exception
						{
							ch.pipeline().addLast(new FixedLengthFrameDecoder(30));// 设置定长解码器
							ch.pipeline().addLast(new StringDecoder());// 设置字符串解码器
							ch.pipeline().addLast(new ClientHandler());// 设置客户端网络IO处理器
						}
					});
			// 连接服务器 同步等待成功
			ChannelFuture f = b.connect(host, port).sync();
			// 同步等待客户端通道关闭
			f.channel().closeFuture().sync();
		}
		finally
		{
			// 释放线程组资源
			group.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception
	{
		int port = 9999;
		new Client().connect(port, "localhost");
	}
}

/*
 * $Log: av-env.bat,v $
 */