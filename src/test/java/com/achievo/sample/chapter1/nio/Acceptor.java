package com.achievo.sample.chapter1.nio;

import java.nio.channels.SocketChannel;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Acceptor.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Acceptor.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  May 27, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class Acceptor implements Runnable
{
	private Reactor reactor;
	
	public Acceptor(Reactor reactor)
	{
		this.reactor = reactor;
	}
	
	@Override
	public void run()
	{
		try
		{
			SocketChannel socketChannel = reactor.sreverSocketChannel.accept();
			if (socketChannel != null)
			{
				new SocketReadHandler(reactor.selector, socketChannel);
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
	}

}

/*
*$Log: av-env.bat,v $
*/