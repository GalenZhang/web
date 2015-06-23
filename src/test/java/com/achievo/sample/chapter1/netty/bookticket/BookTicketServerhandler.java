package com.achievo.sample.chapter1.netty.bookticket;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;
import java.util.Random;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: BookTicketServerhandler.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  订票server端处理器
 * 
 *  Notes:
 * 	$Id: BookTicketServerhandler.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 18, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class BookTicketServerhandler extends ChannelHandlerAdapter
{
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{
		BookRequestMsg requestMsg = (BookRequestMsg) msg;
		BookResponseMsg responseMsg = null;
		switch (requestMsg.getCode())
		{
			case Code.CODE_SEARCH: // 查询余票
				for (Train train : BookTicketServer.trains)
				{
					// 找到车次与请求车次相同的 返回车次余票
					if (requestMsg.getTrainNumber().equals(train.getNumber()))
					{
						responseMsg = new BookResponseMsg();
						responseMsg.setUser(requestMsg.getUser());
						responseMsg.setCode(Code.CODE_SEARCH);
						responseMsg.setSuccess(true);
						responseMsg.setTrain(train);
						responseMsg.setStartTime(requestMsg.getStartTime());
						responseMsg.setMsg("火车【" + train.getNumber() + "】余票数量为【" + train.getTicketCounts() + "】");
						break;
					}
				}

				if (responseMsg == null)
				{
					responseMsg = new BookResponseMsg();
					responseMsg.setUser(requestMsg.getUser());
					responseMsg.setCode(Code.CODE_SEARCH);
					responseMsg.setSuccess(false);
					responseMsg.setMsg("火车【" + requestMsg.getTrainNumber() + "】的信息不存在！");
				}
				break;
			case Code.CODE_BOOK: // 确认订票
				for (Train train : BookTicketServer.trains)
				{
					if (requestMsg.getTrainNumber().equals(train.getNumber()))
					{
						responseMsg = new BookResponseMsg();
						responseMsg.setUser(requestMsg.getUser());
						responseMsg.setCode(Code.CODE_BOOK);
						responseMsg.setSuccess(true);
						responseMsg.setMsg("恭喜您，订票成功！");
						Ticket ticket = new Ticket();
						ticket.setBookTime(new Date());
						ticket.setUser(requestMsg.getUser());
						ticket.setStartTime(requestMsg.getStartTime());
						ticket.setNumber(train.getNumber() + System.currentTimeMillis());// 生成车票编号
						ticket.setCarriageNumber(new Random().nextInt(15));// 随机车厢
						ticket.setUser(requestMsg.getUser());// 设置订票人信息
						String[] seat = new String[] {"A", "B", "C", "D", "E"};
						Random seatRandom = new Random();
						ticket.setSeatNumber(seat[seatRandom.nextInt(5)] + seatRandom.nextInt(100));
						ticket.setTrainNumber(train.getNumber());
						train.setTicketCounts(train.getTicketCounts() - 1);// 余票减去一张
						responseMsg.setTrain(train);
						responseMsg.setTicket(ticket);
						break;
					}
				}

				if (responseMsg == null)
				{
					responseMsg = new BookResponseMsg();
					responseMsg.setUser(requestMsg.getUser());
					responseMsg.setCode(Code.CODE_BOOK);
					responseMsg.setSuccess(false);
					responseMsg.setMsg("火车【" + requestMsg.getTrainNumber() + "】的信息不存在！");
				}
				break;
			default:// 无法处理
				responseMsg = new BookResponseMsg();
				responseMsg.setUser(requestMsg.getUser());
				responseMsg.setCode(Code.CODE_NONE);
				responseMsg.setSuccess(false);
				responseMsg.setMsg("指令无法处理！");
				break;
		}

		ctx.writeAndFlush(responseMsg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
	{
		cause.printStackTrace();
		ctx.close();
	}
}

/*
 * $Log: av-env.bat,v $
 */