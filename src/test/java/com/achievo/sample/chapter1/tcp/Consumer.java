package com.achievo.sample.chapter1.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Consumer.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Consumer.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Apr 16, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class Consumer
{
	@Test
	public void testSend() throws NoSuchMethodException, SecurityException, UnknownHostException, IOException, ClassNotFoundException
	{
		String interfaceName = HelloService.class.getName();
		Method method = HelloService.class.getMethod("sayHello", java.lang.String.class);
		
		Object[] arguments = {"hello"};
		Socket socket = new Socket("127.0.0.1", 1234);
		
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		output.writeUTF(interfaceName);
		output.writeUTF(method.getName());
		output.writeObject(method.getParameterTypes());
		output.writeObject(arguments);
		
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		Object result = input.readObject();
		System.out.println(result);
	}
}

/*
*$Log: av-env.bat,v $
*/