package com.test.controller;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.bean.User;
import com.test.service.UserService;
import com.test.util.EmailUtil;
import com.test.util.JsoupUtil;
@Controller
@RequestMapping(value="test")
public class TestController {
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/hello")
	public String hello(){
		userService.printInfo();
		EmailUtil.sendEmail("test", "just a test");
		return "<h1>Hello in TestController</h1>";
	}
	@ResponseBody
	@RequestMapping(value="/js")
	public String jsp(){
		return "indaex";
	}
	@RequestMapping(value="/hi")
	public String hi(){
		String title=JsoupUtil.getTitleFromUrl("https://www.baidu.com");
		System.out.println(title);
		return "index";
	}

}
