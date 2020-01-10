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
		
		model.addAttribute("test");
		
		
		
		System.out.println("java spring test - project name 'first spring");
		String code = "005930";
		String url = "https://finance.naver.com/item/main.nhn?code="+code;
		try {
			Document doc = Jsoup.connect(url).get();
			Elements nametag = doc.body().getElementsByClass("wrap_company");
			Elements nametag2 = nametag.select("h2");
			Elements doctag = doc.body().getElementsByClass("no_today");
			Elements today_no = doctag.select("em");
			
			String n_context = nametag2.text(); //b
			String context = today_no.text();   //a
			model.addAttribute("a",context);
			model.addAttribute("b", n_context);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		return "index";
	}
}
