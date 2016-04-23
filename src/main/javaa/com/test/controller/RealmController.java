package com.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Administrator Email:ciscog@yeah.net
 * @date   Created at:2016年4月22日下午5:30:31
 */
@Controller
@RequestMapping(value="/realm")
public class RealmController {
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLogin(){
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String postLogin(HttpServletRequest request){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		Subject subject=SecurityUtils.getSubject();
		try{
		subject.login(token);		
		return "redirect:/test/hi";
		}catch(Exception e){
			return "redirect:/realm/login";
		}
		
	}

}
