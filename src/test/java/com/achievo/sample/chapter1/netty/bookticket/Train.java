package com.achievo.sample.chapter1.netty.bookticket;

import java.io.Serializable;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Train.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  http://my.oschina.net/imhoodoo/blog/361076 Netty5入门学习笔记004-使用Netty传输POJO对象
 * 
 *  Notes:
 * 	$Id: Train.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Train implements Serializable
{

	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = -4769269593374872963L;

	private String number; // 火车车次

	private int ticketCounts; // 余票数量

	public Train(String number, int ticketCounts)
	{
		this.number = number;
		this.ticketCounts = ticketCounts;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public int getTicketCounts()
	{
		return ticketCounts;
	}

	public void setTicketCounts(int ticketCounts)
	{
		this.ticketCounts = ticketCounts;
	}

}

/*
 * $Log: av-env.bat,v $
 */