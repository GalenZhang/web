package com.achievo.sample.chapter1.protobuf;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.Test;

import com.achievo.sample.chapter1.protobuf.PersonProtos.Person;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: ProtocolBufferExample.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ProtocolBufferExample.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 1, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class ProtocolBufferTest
{
	@Test
	public void testProtocolBuf()
	{
		Person person1 = Person.newBuilder().setName("ZhangSan").setEmail("zhangsan@yahoo.com").setId(11)
				.addPhone(Person.PhoneNumber.newBuilder().setNumber("13612345678").setType(0))
				.addPhone(Person.PhoneNumber.newBuilder().setNumber("075512345678").setType(1)).build();
		
		try
		{
			FileOutputStream output = new FileOutputStream("d:/3.txt");
			person1.writeTo(output);
			output.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			FileInputStream input = new FileInputStream("d:/3.txt");
			Person person2 = Person.parseFrom(input);
			System.out.println("person2: " + person2);
			input.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

/*
 * $Log: av-env.bat,v $
 */