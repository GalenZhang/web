package com.achievo.sample.designpatterns.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: TreeNode.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: TreeNode.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class TreeNode
{
	private String name;

	private TreeNode parent;

	private Vector<TreeNode> children = new Vector<TreeNode>();

	public TreeNode(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public TreeNode getParent()
	{
		return parent;
	}

	public void setParent(TreeNode parent)
	{
		this.parent = parent;
	}

	// 添加孩子节点
	public void add(TreeNode node)
	{
		children.add(node);
	}

	// 删除孩子节点
	public void remove(TreeNode node)
	{
		children.remove(node);
	}

	// 取得孩子节点
	public Enumeration<TreeNode> getChildren()
	{
		return children.elements();
	}
}

/*
 * $Log: av-env.bat,v $
 */