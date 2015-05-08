package com.achievo.sample.chapter1.mina;

import java.util.Scanner;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: RunClient.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  运行客户端程序
 * 
 *  Notes:
 * 	$Id: RunClient.java 72642 2009-01-01 20:01:57Z ACHIEVO\galen.zhang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  May 5, 2015		galen.zhang		Initial.
 *  
 * </pre>
 */
public class RunClient {
	 
    public static void main(String[] args) {
        MinaClient client = new MinaClient();
        if (client.connect()) {
            client.send("连接服务器成功！");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                client.send(scanner.next());
            }
            
            scanner.close();
        }
    }
}

/*
*$Log: av-env.bat,v $
*/