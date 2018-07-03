package com.feng.search;

import java.util.List;

import org.jsoup.nodes.Document;

import com.feng.crawl.PageCrawl;
import com.feng.crawl.PageHandler;
import com.feng.domain.Resource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Document doc = PageCrawl.pageCrawl("http://www.btcerises.net/search?keyword='变形金刚'", "get", null);
    	System.out.println(doc);
    	//List<Resource> list = PageHandler.pageHandler(doc);
    }
}
