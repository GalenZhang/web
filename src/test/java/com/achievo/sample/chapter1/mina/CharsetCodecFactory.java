package com.achievo.sample.chapter1.mina;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: CharsetCodecFactory.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  字符编码、解码工厂类，编码过滤工厂
 * 
 *  Notes:
 * 	$Id: CharsetCodecFactory.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  May 4, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class CharsetCodecFactory implements ProtocolCodecFactory {
	 
    @Override
    public ProtocolDecoder getDecoder(IoSession session) throws Exception {
        return new CharsetDecoder();
    }
 
    @Override
    public ProtocolEncoder getEncoder(IoSession session) throws Exception {
        return new CharsetEncoder();
    }
}

/*
*$Log: av-env.bat,v $
*/