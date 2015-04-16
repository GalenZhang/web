package com.achievo.sample.chapter1.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: SerializeTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: SerializeTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Apr 16, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class SerializeTest
{
	@Test
	public void testSerialize() throws IOException, ClassNotFoundException
	{
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(os);
		out.writeObject("ZhangSan");
		byte[] zhangsanByte = os.toByteArray();
		
		ByteArrayInputStream is = new ByteArrayInputStream(zhangsanByte);
		ObjectInputStream in = new ObjectInputStream(is);
		String str = (String)in.readObject();
		System.out.println(str);
	}
	
	@Test
	public void testHessianSerialize() throws IOException, ClassNotFoundException
	{
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		HessianOutput out = new HessianOutput(os);
		out.writeObject("Hessian read ZhangSan");
		byte[] zhangsanByte = os.toByteArray();
		
		ByteArrayInputStream is = new ByteArrayInputStream(zhangsanByte);
		HessianInput in = new HessianInput(is);
		String str = (String)in.readObject();
		System.out.println(str);
	}
}

/*
*$Log: av-env.bat,v $
*/