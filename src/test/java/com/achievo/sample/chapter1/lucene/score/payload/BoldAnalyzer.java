package com.achievo.sample.chapter1.lucene.score.payload;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: BoldAnalyzer.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: BoldAnalyzer.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 8, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class BoldAnalyzer extends Analyzer
{
	@Override
	protected TokenStreamComponents createComponents(String fieldName)
	{
		Tokenizer tokenizer = new WhitespaceTokenizer();
		TokenStream tokenStream = new BoldFilter(tokenizer);
		tokenStream = new LowerCaseFilter(tokenStream);
		tokenStream = new StopFilter(tokenStream, StopAnalyzer.ENGLISH_STOP_WORDS_SET);
		return new TokenStreamComponents(tokenizer, tokenStream);
	}
}

/*
 * $Log: av-env.bat,v $
 */