package com.achievo.sample.chapter1.lucene.pinyin;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;

import com.achievo.sample.chapter1.lucene.util.AnalyzerUtils;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: PinyinAnalyzerTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: PinyinAnalyzerTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 8, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class PinyinAnalyzerTest
{
	public static void main(String[] args) throws IOException
	{
		String text = "2011年3月31日，孙燕姿与相恋5年多的男友纳迪姆在新加坡登记结婚";
		Analyzer analyzer = new PinyinAnalyzer(20);
		AnalyzerUtils.displayTokens(analyzer, text);
	}
}

/*
 * $Log: av-env.bat,v $
 */