package com.example.demo.Contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

	//jsoup 크롤링 도구 import 

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
			Elements ex_day = doc.body().getElementsByClass("no_exday");
			Elements ex_day2 = ex_day.select("em");
			
			String context = today_no.text();   //a
			String n_context = nametag2.text(); //b
			String e_context = ex_day2.text(); //c
			
			model.addAttribute("a",n_context);
			model.addAttribute("b", context);
			model.addAttribute("c", e_context);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		return "index";
	}
}
