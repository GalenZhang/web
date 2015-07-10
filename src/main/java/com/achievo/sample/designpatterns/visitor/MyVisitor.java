package com.achievo.sample.designpatterns.visitor;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: MyVisitor.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: MyVisitor.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class MyVisitor implements Visitor
{

	@Override
	public void visit(Subject sub)
	{
		System.out.println("visit the subject：" + sub.getSubject());
	}
}

/*
 * $Log: av-env.bat,v $
 */