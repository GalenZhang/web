package com.achievo.sample.chapter1.netty.bookticket;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: BookTicketClient.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  订票客户端
 * 
 *  Notes:
 * 	$Id: BookTicketClient.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class BookTicketClient
{
	public void connect(int port, String host) throws Exception
	{
		// 配置客户端线程组
		EventLoopGroup group = new NioEventLoopGroup();
		try
		{
			// 配置客户端启动辅助类
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>()
					{
						@Override
						protected void initChannel(SocketChannel ch) throws Exception
						{
							// 添加POJO对象解码器 禁止缓存类加载器
							ch.pipeline()
									.addLast(
										new ObjectDecoder(1024, ClassResolvers.cacheDisabled(this.getClass()
												.getClassLoader())));
							// 设置发送消息编码器
							ch.pipeline().addLast(new ObjectEncoder());
							// 设置网络IO处理器
							ch.pipeline().addLast(new BookTicketClientHandler());
						}
					});
			// 发起异步服务器连接请求 同步等待成功
			ChannelFuture f = b.connect(host, port).sync();
			// 等到客户端链路关闭
			f.channel().closeFuture().sync();
		}
		finally
		{
			group.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception
	{
		new BookTicketClient().connect(9999, "localhost");
	}
}

/*
 * $Log: av-env.bat,v $
 */