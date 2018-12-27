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

public class LoginUserLogInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(HttpServletRequest request, 
						   HttpServletResponse response, 
						   Object handler,
						   ModelAndView modelAndView) throws Exception {
		
		MemberVO loginUser = 
				(MemberVO)request.getSession().getAttribute("loginUser");
		
		String log="[login:user]";
		log+=loginUser.getId()+","
				+loginUser.getName()+","
				+request.getRemoteAddr()+","
				+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		String savePath="d:\\log";
		if(!new File(savePath).exists()){
			new File(savePath).mkdirs();
		}
		
		String logFilePath=savePath+File.separator+"login_user_log.txt";
			
		BufferedWriter out=
				new BufferedWriter(new FileWriter(logFilePath,true));
		
		 out.write(log);
		 out.newLine();
		 out.close();
	
	}
	
	
	
}
