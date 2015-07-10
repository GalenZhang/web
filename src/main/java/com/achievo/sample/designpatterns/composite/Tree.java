package com.achievo.sample.designpatterns.composite;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Tree.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Tree.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Tree
{
	TreeNode root = null;

	public Tree(String name)
	{
		root = new TreeNode(name);
	}

	public static void main(String[] args)
	{
		Tree tree = new Tree("A");
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");

		nodeB.add(nodeC);
		tree.root.add(nodeB);
		System.out.println("build the tree finished!");
	}
}

/*
 * $Log: av-env.bat,v $
 */