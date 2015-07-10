package com.achievo.sample.designpatterns.facade;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Computer.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Computer.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Computer
{
	private CPU cpu;

	private Memory memory;

	private Disk disk;

	public Computer()
	{
		cpu = new CPU();
		memory = new Memory();
		disk = new Disk();
	}

	public void startup()
	{
		System.out.println("start the computer!");
		cpu.startup();
		memory.startup();
		disk.startup();
		System.out.println("start computer finished!");
	}

	public void shutdown()
	{
		System.out.println("begin to close the computer!");
		cpu.shutdown();
		memory.shutdown();
		disk.shutdown();
		System.out.println("computer closed!");
	}
}

/*
 * $Log: av-env.bat,v $
 */