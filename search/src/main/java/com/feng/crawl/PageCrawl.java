package com.feng.crawl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * 页面爬取
 * @author Administrator
 *
 */
public class PageCrawl {
	private static HttpClient httpClient;
	static {
		httpClient = HttpClientBuilder.create().build();
	}
	
	private PageCrawl() {
	}
	
	public static Document pageCrawl(String url,String method,Map<String, String> map) {
		Document document = null;
		if("post".equalsIgnoreCase(method)) {
			
		}
		if("get".equalsIgnoreCase(method)) {
			document = pageCrawlGet(url);
		}
		return document;
	}
	
	private static Document pageCrawlGet(String url) {
		HttpGet httpGet = new HttpGet(url);
		RequestConfig config =RequestConfig.custom().setConnectTimeout(10000).setSocketTimeout(10000).build();
		httpGet.setConfig(config);
		Document doc = null;
		try {
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			InputStream in = entity.getContent();
			doc = Jsoup.parse(in, "utf-8", "dfsd");
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}
}
