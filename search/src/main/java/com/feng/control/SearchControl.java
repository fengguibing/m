package com.feng.control;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.feng.crawl.PageCrawl;
import com.feng.crawl.PageHandler;
import com.feng.domain.Resource;
import com.feng.util.Parameter;


@Controller
@RequestMapping
public class SearchControl {
	
	@RequestMapping(value="/search.action",method=RequestMethod.POST)
	public String search(String searchName,String p,Model model) {
		try {
			searchName = new String(searchName.getBytes("iso8859-1"), 0,searchName.getBytes("iso8859-1").length);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String url = null;
		if(p != null) {
			url = "http://www.btcerises.net/search?keyword=" + searchName + "&p=" + p;
		}else {
			url = "http://www.btcerises.net/search?keyword=" + searchName;
		}
		Document docment = PageCrawl.pageCrawl(url, "get", null);
		List<Resource> list = PageHandler.pageHandler(docment);
		model.addAttribute("list",list);
		int page = 1;
		if(searchName.contains("&")){
			String[] strs = searchName.split("=");
			page = Integer.parseInt(strs[1]);
		}
		model.addAttribute("searchName", searchName);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPage", Parameter.totalPage);
		model.addAttribute("total", Parameter.total);
		return "showList";
	}
	@RequestMapping(value="/search.action",method=RequestMethod.GET)
	public String searchGet(String searchName,String p,Model model) {
		try {
			searchName = URLDecoder.decode(searchName,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String url = null;
		if(p != null) {
			url = "http://www.btcerises.net/search?keyword=" + searchName + "&p=" + p;
		}else {
			url = "http://www.btcerises.net/search?keyword=" + searchName;
		}
		Document docment = PageCrawl.pageCrawl(url, "get", null);
		List<Resource> list = PageHandler.pageHandler(docment);
		model.addAttribute("list",list);
		int page = 1;
		if(p != null){
			page = Integer.parseInt(p);
		}
		model.addAttribute("searchName", searchName);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPage", Parameter.totalPage);
		model.addAttribute("total", Parameter.total);
		return "showList";
	}
}
