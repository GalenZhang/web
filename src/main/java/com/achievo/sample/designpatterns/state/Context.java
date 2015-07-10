package com.achievo.sample.designpatterns.state;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Context.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Context.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Context
{
	private State state;

	public Context(State state)
	{
		this.state = state;
	}

	public State getState()
	{
		return state;
	}

	public void setState(State state)
	{
		this.state = state;
	}

	public void method()
	{
		if (state.getValue().equals("state1"))
		{
			state.method1();
		}
		else if (state.getValue().equals("state2"))
		{
			state.method2();
		}
	}
}

/*
 * $Log: av-env.bat,v $
 */