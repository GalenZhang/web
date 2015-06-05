package com.achievo.sample.chapter1.lucene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: SimpleDemo.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  http://blog.csdn.net/jasonware/article/details/45532137  Lucene5 一个简单的Demo
 * 
 *  Notes:
 * 	$Id: SimpleDemo.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 5, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class SimpleDemo
{
	public static void main(String[] args) throws IOException
	{
		String dirPath = "d://test";
		String indexPath = "d://lucene";
		createIndex(dirPath, indexPath, false);
	}

	/**
	 * 创建索引
	 * 
	 * @param dirPath 需要索引的文件目录
	 * @param indexPath 索引存放目录
	 * @param createOrAppend
	 * @throws IOException
	 */
	public static void createIndex(String dirPath, String indexPath, boolean createOrAppend) throws IOException
	{
		long startTime = System.currentTimeMillis();
		Directory directory = FSDirectory.open(Paths.get(indexPath));
		Path docDirPath = Paths.get(dirPath);
		Analyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig conf = new IndexWriterConfig(analyzer);
		if (createOrAppend)
		{
			conf.setOpenMode(OpenMode.CREATE_OR_APPEND);
		}
		else
		{
			conf.setOpenMode(OpenMode.CREATE);
		}

		IndexWriter indexWriter = new IndexWriter(directory, conf);
		indexDocs(indexWriter, docDirPath);
		indexWriter.close();
		System.out.println(System.currentTimeMillis() - startTime);
	}

	/**
	 * 根据文件路径对文件内容进行索引 如果是目录则扫描目录下的文件
	 * 
	 * @param indexWriter
	 * @param path
	 * @throws IOException
	 */
	private static void indexDocs(final IndexWriter indexWriter, Path path) throws IOException
	{
		if (Files.isDirectory(path, new LinkOption[0]))
		{
			Files.walkFileTree(path, new SimpleFileVisitor<Path>()
			{
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
				{
					indexDoc(indexWriter, file, attrs.lastModifiedTime().toMillis());
					return FileVisitResult.CONTINUE;
				}
			});
		}
		else
		{
			indexDoc(indexWriter, path, Files.getLastModifiedTime(path, new LinkOption[0]).toMillis());
		}
	}

	/**
	 * 根据文件路径对文件内容进行索引
	 * 
	 * @param indexWriter
	 * @param path
	 * @throws IOException
	 */
	public static void indexDoc(IndexWriter indexWriter, Path path, long lastModified) throws IOException
	{
		Document document = new Document();
		Field pathField = new StringField("path", path.toString(), Field.Store.YES);
		document.add(pathField);
		Field lastModifiedField = new LongField("modified", lastModified, Field.Store.NO);
		document.add(lastModifiedField);
		Field contentField = new TextField("content", new BufferedReader(new InputStreamReader(Files.newInputStream(
			path, new OpenOption[0]), StandardCharsets.UTF_8)));
		document.add(contentField);
		if (indexWriter.getConfig().getOpenMode() == IndexWriterConfig.OpenMode.CREATE)
		{
			indexWriter.addDocument(document);
		}
		else
		{
			indexWriter.updateDocument(new Term("path", path.toString()), document);
		}
		indexWriter.commit();
	}
}

/*
 * $Log: av-env.bat,v $
 */