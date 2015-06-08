package com.achievo.sample.chapter1.lucene.pinyin;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.StopFilter;
import org.wltea.analyzer.lucene.IKTokenizer;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: PinyinAnalyzer.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: PinyinAnalyzer.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 8, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class PinyinAnalyzer extends Analyzer
{
	private int minGram;

	private int maxGram;

	private boolean useSmart;

	public PinyinAnalyzer()
	{
		super();
		this.maxGram = Constant.DEFAULT_MAX_GRAM;
		this.minGram = Constant.DEFAULT_MIN_GRAM;
		this.useSmart = Constant.DEFAULT_IK_USE_SMART;
	}

	public PinyinAnalyzer(boolean useSmart)
	{
		super();
		this.maxGram = Constant.DEFAULT_MAX_GRAM;
		this.minGram = Constant.DEFAULT_MIN_GRAM;
		this.useSmart = useSmart;
	}

	public PinyinAnalyzer(int maxGram)
	{
		super();
		this.maxGram = maxGram;
		this.minGram = Constant.DEFAULT_MIN_GRAM;
		this.useSmart = Constant.DEFAULT_IK_USE_SMART;
	}

	public PinyinAnalyzer(int maxGram, boolean useSmart)
	{
		super();
		this.maxGram = maxGram;
		this.minGram = Constant.DEFAULT_MIN_GRAM;
		this.useSmart = useSmart;
	}

	public PinyinAnalyzer(int minGram, int maxGram, boolean useSmart)
	{
		super();
		this.minGram = minGram;
		this.maxGram = maxGram;
		this.useSmart = useSmart;
	}

	@Override
	protected TokenStreamComponents createComponents(String fieldName)
	{
		Reader reader = new BufferedReader(new StringReader(fieldName));
		Tokenizer tokenizer = new IKTokenizer(reader, useSmart);
		// 转拼音
		TokenStream tokenStream = new PinyinTokenFilter(tokenizer, Constant.DEFAULT_FIRST_CHAR,
				Constant.DEFAULT_MIN_TERM_LRNGTH);
		// 对拼音进行NGram处理
		tokenStream = new PinyinNGramTokenFilter(tokenStream, this.minGram, this.maxGram);
		tokenStream = new LowerCaseFilter(tokenStream);
		tokenStream = new StopFilter(tokenStream, StopAnalyzer.ENGLISH_STOP_WORDS_SET);
		return new Analyzer.TokenStreamComponents(tokenizer, tokenStream);
	}

}

/*
 * $Log: av-env.bat,v $
 */