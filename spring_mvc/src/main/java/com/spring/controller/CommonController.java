package com.spring.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.exception.IdNotFoundException;
import com.spring.exception.InvalidPasswordException;
import com.spring.service.CommonService;

@Controller
public class CommonController {
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginForm()throws Exception{
		String url="loginForm";
		return url;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(LoginRequest loginReq,Model model)throws Exception{
		
		String url="redirect:main";
		
		try {
			commonService.login(loginReq);
		} catch (IdNotFoundException e) {			
			url="loginForm";
			model.addAttribute("id",loginReq.getId());
			model.addAttribute("msg","아이디가 존재하지 않습니다.");
		} catch (InvalidPasswordException e) {
			url="loginForm";
			model.addAttribute("id",loginReq.getId());
			model.addAttribute("msg","패스워드가 일치하지 않습니다.");
		} catch (SQLException e) {			
			e.printStackTrace();
			url="error/exception";
			model.addAttribute("error",e);
		}
		
		return url;
	}
	
}






