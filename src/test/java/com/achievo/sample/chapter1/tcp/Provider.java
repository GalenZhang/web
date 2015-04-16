package com.achievo.sample.chapter1.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Provider.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Provider.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Apr 16, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class Provider
{
	@Test
	public void testReceive() throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Map<String, Object> services = new HashMap<String, Object>();
		services.put("com.achievo.sample.chapter1.tcp.HelloService", new HelloServiceImpl());
		
		ServerSocket server = new ServerSocket(1234);
		while(true)
		{
			Socket socket = server.accept();
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			String interfaceName = input.readUTF();
			String methodName = input.readUTF();
			Class<?>[] parameterTypes = (Class<?>[])input.readObject();
			Object[] arguments = (Object[])input.readObject();
			
			Class serviceInterfaceClass = Class.forName(interfaceName);
			Object service = services.get(interfaceName);
			Method method = serviceInterfaceClass.getMethod(methodName, parameterTypes);
			Object result = method.invoke(service, arguments);
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject(result);
			break;
		}
	}
}

/*
*$Log: av-env.bat,v $
*/