package com.achievo.sample.designpatterns.interpreter;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Expression.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Expression.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public interface Expression
{
	public int interpret(Context context);
}

/*
 * $Log: av-env.bat,v $
 */