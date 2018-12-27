package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.LoginDataVO;
import com.spring.service.LoginDataService;

@Controller
@RequestMapping("/log")
public class LogManageController {

	@Autowired
	private LoginDataService logService;
	
	@RequestMapping("/list")
	public void logList(Model model)throws Exception{
		List<LoginDataVO> logList=logService.getLoginData();
		model.addAttribute("logList",logList);
	}
}







