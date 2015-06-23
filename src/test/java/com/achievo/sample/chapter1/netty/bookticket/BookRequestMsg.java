package com.achievo.sample.chapter1.netty.bookticket;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: BookRequestMsg.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  订票人发送查询余票和订票使用的请求信息
 * 
 *  Notes:
 * 	$Id: BookRequestMsg.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class BookRequestMsg implements Serializable
{

	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = 7055947022199309470L;

	private User user;// 发送订票信息用户

	private String trainNumber;// 火车车次

	private int code;// 查询命令

	private Date startTime;// 开车时间

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public String getTrainNumber()
	{
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber)
	{
		this.trainNumber = trainNumber;
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public Date getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

}

/*
 * $Log: av-env.bat,v $
 */