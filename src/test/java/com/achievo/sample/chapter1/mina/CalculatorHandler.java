package com.achievo.sample.chapter1.mina;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: CalculatorHandler.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: CalculatorHandler.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Apr 30, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class CalculatorHandler extends IoHandlerAdapter
{
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorHandler.class);

	private ScriptEngine jsEngine = null;

	public CalculatorHandler()
	{
		ScriptEngineManager sfm = new ScriptEngineManager();
		jsEngine = sfm.getEngineByName("JavaScript");
		if (jsEngine == null)
		{
			throw new RuntimeException("找不到 JavaScript 引擎。");
		}
	}

	public void exceptionCaught(IoSession session, Throwable cause) throws Exception
	{
		LOGGER.warn(cause.getMessage(), cause);
	}

	public void messageReceived(IoSession session, Object message) throws Exception
	{
		String expression = message.toString();
		if ("quit".equalsIgnoreCase(expression.trim()))
		{
			session.close(true);
			return;
		}
		try
		{
			Object result = jsEngine.eval(expression);
			session.write(result.toString());
		}
		catch (ScriptException e)
		{
			LOGGER.warn(e.getMessage(), e);
			session.write("Wrong expression, try again.");
		}
	}
}

/*
 * $Log: av-env.bat,v $
 */