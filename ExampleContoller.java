package com.example.demo.Contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
@Controller
public class ExampleContoller {
	@RequestMapping(value="/")
	public String main(Model model, HttpServletRequest request) {
		
		model.addAttribute("test", "안녕하세요");
		
		
		
		System.out.println("java spring test - project name 'first spring");
		
		String url = "https://sports.news.naver.com/index.nhn";
		try {
			Document doc = Jsoup.connect(url).get();
			Elements doctag = doc.body().getElementsByClass("sports_home");
			String context = doctag.text();
			model.addAttribute("a",context);
			//Elements docimgtag2 = doc.body().getElementByClass
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		return "index";
	}
}
