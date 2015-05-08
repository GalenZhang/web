package com.achievo.sample.chapter1.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: CalculatorServer.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: CalculatorServer.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Apr 30, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class CalculatorServer
{
	private static final int PORT = 10010;

	private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorServer.class);

	public static void main(String[] args) throws IOException
	{
		IoAcceptor acceptor = new NioSocketAcceptor();

		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec",
			new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

		acceptor.setHandler(new CalculatorHandler());
		acceptor.bind(new InetSocketAddress(PORT));

		LOGGER.info("计算器服务已启动，端口是" + PORT);
	}
}

/*
 * $Log: av-env.bat,v $
 */