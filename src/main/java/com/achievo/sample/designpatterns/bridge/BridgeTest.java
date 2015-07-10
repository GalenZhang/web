package com.achievo.sample.designpatterns.bridge;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: BridgeTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: BridgeTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class BridgeTest
{
	public static void main(String[] args)
	{

		Bridge bridge = new MyBridge();

		/* 调用第一个对象 */
		Sourceable source1 = new SourceSub1();
		bridge.setSource(source1);
		bridge.method();

		/* 调用第二个对象 */
		Sourceable source2 = new SourceSub2();
		bridge.setSource(source2);
		bridge.method();
	}
}

/*
 * $Log: av-env.bat,v $
 */