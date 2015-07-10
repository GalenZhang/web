package com.achievo.sample.designpatterns.iterator;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Collection.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Collection.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public interface Collection
{
	public Iterator iterator();

	/* 取得集合元素 */
	public Object get(int i);

	/* 取得集合大小 */
	public int size();
}

/*
 * $Log: av-env.bat,v $
 */