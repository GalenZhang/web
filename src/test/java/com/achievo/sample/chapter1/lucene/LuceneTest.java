package com.achievo.sample.chapter1.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: LuceneTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  http://blog.csdn.net/u012443091/article/details/43973127  Lucene5.0索引的创建与搜索
 * 
 *  Notes:
 * 	$Id: LuceneTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 4, 2015		galen.zhang		Initial.
 * 
 * </pre>
 */
public class LuceneTest
{
	private static Directory directory;

	private IndexWriter writer;

	private IndexReader reader;

	static
	{
		try
		{
			// 读取硬盘上的索引信息
			directory = FSDirectory.open(Paths.get("d://lucene"));
			// 读取内存中的索引信息 因为是在内存中 所以不需要指定索引文件夹
			// directory = new RAMDirectory();
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}

	/**
	 * 将Directory做成静态对象 便于获取
	 * 
	 * @return
	 */
	public static Directory getDirectory()
	{
		return directory;
	}

	public IndexWriter getWriter(OpenMode createOrAppend)
	{
		if (writer != null)
			return writer;

		Analyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig conf = new IndexWriterConfig(analyzer);
		if (createOrAppend == null)
		{
			// 默认策略为新建索引
			conf.setOpenMode(OpenMode.CREATE);
		}
		else
		{
			conf.setOpenMode(createOrAppend);
		}

		try
		{
			writer = new IndexWriter(directory, conf);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return writer;
	}

	public IndexReader getIndexReader()
	{
		try
		{
			DirectoryReader newReader = null;
			// 判断reader是否为空 若为空就创建一个新的reader
			if (reader == null)
			{
				reader = DirectoryReader.open(directory);
			}
			else
			{
				// 若不为空 查看索引文件是否发生改变 如果发生改变就重新创建reader
				newReader = DirectoryReader.openIfChanged((DirectoryReader) reader);
			}

			if (newReader != null)
			{
				reader = newReader;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return reader;
	}

	/**
	 * 获取IndexSearcher对象
	 * 
	 * @return
	 */
	public IndexSearcher getIndexSearcher()
	{
		return new IndexSearcher(getIndexReader());
	}

	/**
	 * 创建索引 有几个概念需要理解 1. Directory类似于数据库中的表 2. Document类似于数据库的一条记录 3. Field类似于数据库中一条记录的某一列
	 */
	public void index()
	{
		Document document = null;
		writer = getWriter(OpenMode.CREATE);

		// 设置需要被索引文件的文件夹
		File file = new File("d://test");
		// 遍历需要被索引的文件夹
		for (File f : file.listFiles())
		{
			document = new Document();

			try
			{
				/**
				 * 自Lucene4开始 创建field对象使用不同的类型 只需要指定是否需要保存源数据 不需指定分词类别 之前版本的写法如下 doc.Add(new Field("id",
				 * item.id.ToString(), Field.Store.YES, Field.Index.ANALYZED));
				 */
				Field field = new StringField("fileName", f.getName(), Store.YES);
				document.add(field);
				Field field2 = new LongField("fileSize", f.length(), Store.NO);
				document.add(field2);
				Field field3 = new LongField("fileLastModified", f.lastModified(), Store.NO);
				document.add(field3);
				Field field4 = new TextField("content", new BufferedReader(new InputStreamReader(
						new FileInputStream(f), StandardCharsets.UTF_8)));
				document.add(field4);

				if (writer.getConfig().getOpenMode() == OpenMode.CREATE)
				{
					System.out.println("adding " + f);
					writer.addDocument(document);
				}
				else
				{
					System.out.println("updating " + f);
					writer.updateDocument(new Term("path", f.toString()), document);
				}
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		try
		{
			// 如果不是时常创建索引 一定要记得关闭writer 当然也可以将writer设计成单例的
			if (writer != null)
				writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void search(String queryStr, int num)
	{
		// 默认搜索content域 使用标准分词器
		QueryParser parser = new QueryParser("content", new StandardAnalyzer());
		IndexSearcher searcher = getIndexSearcher();
		try
		{
			Query query = parser.parse(queryStr);
			TopDocs docs = searcher.search(query, num);
			System.out.println("一共搜索到结果:" + docs.totalHits + "条");
			for (ScoreDoc scoreDoc : docs.scoreDocs)
			{
				System.out.print("序号为:" + scoreDoc.doc);
				System.out.print(" 评分为:" + scoreDoc.score);
				Document document = searcher.doc(scoreDoc.doc);
				System.out.print(" 文件名:" + document.get("fileName"));
				System.out.print(" 内容为:" + document.get("content"));
				System.out.print(" 文件大小:" + document.get("fileSize"));
				System.out.print(" 文件日期:" + document.get("fileLastModified"));
				System.out.println();
			}
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

/*
 * $Log: av-env.bat,v $
 */