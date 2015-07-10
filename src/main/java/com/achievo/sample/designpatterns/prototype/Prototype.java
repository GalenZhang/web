package com.achievo.sample.designpatterns.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Prototype.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Prototype.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class Prototype implements Cloneable, Serializable
{

	private static final long serialVersionUID = 1L;

	private String string;

	private SerializableObject obj;

	/* 浅复制 */
	public Object clone() throws CloneNotSupportedException
	{
		Prototype proto = (Prototype) super.clone();
		return proto;
	}

	/* 深复制 */
	public Object deepClone() throws IOException, ClassNotFoundException
	{

		/* 写入当前对象的二进制流 */
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);

		/* 读出二进制流产生的新对象 */
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}

	public String getString()
	{
		return string;
	}

	public void setString(String string)
	{
		this.string = string;
	}

	public SerializableObject getObj()
	{
		return obj;
	}

	public void setObj(SerializableObject obj)
	{
		this.obj = obj;
	}

}

class SerializableObject implements Serializable
{
	private static final long serialVersionUID = 1L;
}

/*
 * $Log: av-env.bat,v $
 */