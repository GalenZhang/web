package com.achievo.sample.chapter1.netty.bookticket;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Ticket.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Ticket.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Ticket implements Serializable
{

	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = 1494717541911221388L;

	private String trainNumber;// 火车车次

	private int carriageNumber;// 车厢编号

	private String seatNumber;// 座位编号

	private String number;// 车票编号

	private User user;// 订票用户

	private Date bookTime;// 订票时间

	private Date startTime;// 开车时间

	public String getTrainNumber()
	{
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber)
	{
		this.trainNumber = trainNumber;
	}

	public int getCarriageNumber()
	{
		return carriageNumber;
	}

	public void setCarriageNumber(int carriageNumber)
	{
		this.carriageNumber = carriageNumber;
	}

	public String getSeatNumber()
	{
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber)
	{
		this.seatNumber = seatNumber;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Date getBookTime()
	{
		return bookTime;
	}

	public void setBookTime(Date bookTime)
	{
		this.bookTime = bookTime;
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