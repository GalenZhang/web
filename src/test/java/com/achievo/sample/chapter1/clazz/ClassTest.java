package com.achievo.sample.chapter1.clazz;

import org.junit.Test;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: TestClass.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: TestClass.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 3, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class ClassTest
{
	@Test
	public void testClass()
	{
		ClassTest test = new ClassTest();
		printClassName(test);
	}
	
	private void printClassName(Object obj)
	{
		System.out.println("The class of " + obj + " is " + obj.getClass().getName());
		System.out.println("Simple name: " + obj.getClass().getSimpleName());
		System.out.println("Package name: " + obj.getClass().getPackage());
	}
}

/*
*$Log: av-env.bat,v $
*/