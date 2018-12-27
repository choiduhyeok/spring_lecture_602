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

public class RegistUserLogInterceptor extends HandlerInterceptorAdapter{

	private String savePath="d:\\log";
	public void setSavePath(String savePath){
		this.savePath=savePath;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, 
						   HttpServletResponse response, 
						   Object handler,
			               ModelAndView modelAndView) throws Exception {
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		MemberVO loginUser = 
				(MemberVO)request.getSession().getAttribute("loginUser");
		
		
		String log="[register:user]";
		
		log+=loginUser.getId()+","
			+id+","+name+","+email+","
			+new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		File logPath = new File(savePath);
		
		if(!logPath.exists()){
			logPath.mkdirs();
		}
		
		String logFileName = savePath+File.separator+"regist_user_log.txt";
		
		BufferedWriter out=
				new BufferedWriter(new FileWriter(logFileName,true));
		
		 out.write(log);
		 out.newLine();
		 out.close();
		
	}

	
}
;