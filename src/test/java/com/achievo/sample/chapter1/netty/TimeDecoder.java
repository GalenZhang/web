package com.achievo.sample.chapter1.netty;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: TimeDecoder.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: TimeDecoder.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class TimeDecoder extends ByteToMessageDecoder
{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception
	{
		if (in.readableBytes() < 4)
		{
			return;
		}
		
		out.add(new UnixTime(in.readInt()));
	}

}

/*
*$Log: av-env.bat,v $
*/