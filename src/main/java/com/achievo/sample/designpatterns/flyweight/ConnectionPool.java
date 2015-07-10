package com.achievo.sample.designpatterns.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: ConnectionPool.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ConnectionPool.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class ConnectionPool
{
	private Vector<Connection> pool;

	/* 公有属性 */
	private String url = "jdbc:mysql://localhost:3306/test";

	private String username = "root";

	private String password = "root";

	private String driverClassName = "com.mysql.jdbc.Driver";

	private int poolSize = 100;

	private static ConnectionPool instance = null;

	Connection conn = null;

	/* 构造方法，做一些初始化工作 */
	private ConnectionPool()
	{
		pool = new Vector<Connection>(poolSize);

		for (int i = 0; i < poolSize; i++)
		{
			try
			{
				Class.forName(driverClassName);
				conn = DriverManager.getConnection(url, username, password);
				pool.add(conn);
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	/* 返回连接到连接池 */
	public synchronized void release()
	{
		pool.add(conn);
	}

	/* 返回连接池中的一个数据库连接 */
	public synchronized Connection getConnection()
	{
		if (pool.size() > 0)
		{
			Connection conn = pool.get(0);
			pool.remove(conn);
			return conn;
		}
		else
		{
			return null;
		}
	}
}

/*
 * $Log: av-env.bat,v $
 */