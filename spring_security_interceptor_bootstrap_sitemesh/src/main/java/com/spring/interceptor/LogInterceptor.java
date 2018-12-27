package com.spring.interceptor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.dto.MemberVO;

public class LogInterceptor extends HandlerInterceptorAdapter{
	
	private String savePath="d:\\log";
	public void setSavePath(String savePath){
		this.savePath=savePath;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, 
			               HttpServletResponse response, 
			               Object handler,
			               ModelAndView modelAndView) throws Exception {
		
		MemberVO loginUser = 
			(MemberVO)request.getSession().getAttribute("loginUser");
		
		MemberVO registMember = new MemberVO();
		registMember.setId(request.getParameter("id"));
		registMember.setName(request.getParameter("name"));
		registMember.setEmail(request.getParameter("email"));
		
		String log="[register:user]";
		log+=loginUser.getId()+",";
		log+=registMember.getId()+",";
		log+=registMember.getName()+",";
		log+=registMember.getEmail()+",";
		log+=new SimpleDateFormat("yyyy-MM-dd").format(new Date())+",";
		log+=request.getRemoteAddr();
				
		//mkdir
		File logPath = new File(savePath);
		
		if(!logPath.exists()){
			logPath.mkdirs();
		}
		
		String logFilePath=logPath+File.separator+"regist_user_log.txt";
		
		BufferedWriter out=
				new BufferedWriter(new FileWriter(logFilePath,true));
		
		 out.write(log);
		 out.newLine();
		 out.close();
	}

	
}
