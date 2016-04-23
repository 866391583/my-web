package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator Email:ciscog@yeah.net
 * @date   Created at:2016年4月22日下午6:37:08
 */
@Controller
@RequestMapping(value="/admin")
public class AdminController {
	@ResponseBody
	@RequestMapping(value="/test")
	public String adminTest()
	{
		return "admin test";
	}

}
