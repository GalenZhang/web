package com.achievo.sample.chapter1.netty.bookticket;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: BookResponseMsg.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  订票成功与否反馈信息
 * 
 *  Notes:
 * 	$Id: BookResponseMsg.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class BookResponseMsg implements Serializable
{

	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = 6416862834607130166L;

	private boolean success;// 是否操作成功

	private User user;// 请求用户

	private String msg;// 反馈信息

	private int code;// 请求指令

	private Train train;// 火车车次

	private Date startTime;// 出发时间

	private Ticket ticket;// 订票成功后具体出票票据

	public boolean isSuccess()
	{
		return success;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public Train getTrain()
	{
		return train;
	}

	public void setTrain(Train train)
	{
		this.train = train;
	}

	public Date getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	public Ticket getTicket()
	{
		return ticket;
	}

	public void setTicket(Ticket ticket)
	{
		this.ticket = ticket;
	}

}

/*
 * $Log: av-env.bat,v $
 */