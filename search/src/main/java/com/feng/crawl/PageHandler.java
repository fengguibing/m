package com.feng.crawl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.feng.domain.Resource;
import com.feng.util.Parameter;

/**
 * 页面处理类
 * @author Administrator
 *
 */
public class PageHandler {
	private PageHandler() {
	}
	
	public static List<Resource> pageHandler(Document document){
		List<Resource> list = new ArrayList<>();
		Elements divs = document.select("div");
		for (Element div : divs) {
			if(div.attr("class").equals("r")) {
				try {
					Element child = div.child(1);
					String name = child.tagName();
					if(name.equals("div")) {
						Resource resource = new Resource();
						String fileName = div.child(0).child(0).text();
						resource.setName(fileName);
						Element innerDiv = div.child(1);
						String recordTime = innerDiv.child(0).child(0).text();
						String size = innerDiv.child(1).child(0).text();
						String fileCount = innerDiv.child(2).child(0).text();
						String magnet = innerDiv.child(3).attr("href").split("&")[0];
						resource.setRecordTime(recordTime);
						resource.setFileCount(fileCount);
						resource.setSize(size);
						resource.setMagent(magnet);
						list.add(resource);
					}
				} catch (Exception e) {
				}
			}
			if(div.attr("class").equals("costs")) {
				String text = div.text();
				text = text.substring(3, text.indexOf("条")).trim();
				Parameter.total = text;
				int parseInt = Integer.parseInt(text);
				int pageTotal = parseInt/20;
				if(parseInt%20 == 0) {
					Parameter.totalPage = pageTotal + "";
				}else {
					Parameter.totalPage = (pageTotal + 1) + "";
				}
			}
		}
		return list;
	}
}
