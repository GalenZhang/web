package com.achievo.sample.designpatterns.interpreter;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Test.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Test.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Test
{
	public static void main(String[] args)
	{

		// 计算9+2-8的值
		int result = new Minus().interpret((new Context(new Plus().interpret(new Context(9, 2)), 8)));
		System.out.println(result);
	}
}

/*
 * $Log: av-env.bat,v $
 */