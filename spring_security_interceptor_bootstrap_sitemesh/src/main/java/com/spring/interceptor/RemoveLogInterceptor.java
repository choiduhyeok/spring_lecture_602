package com.spring.interceptor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.dto.MemberVO;
import com.spring.service.MemberService;

public class RemoveLogInterceptor extends HandlerInterceptorAdapter{

	private MemberService memberService;
	public void setMemberService(MemberService memberService){
		this.memberService=memberService; 
	}
	
	private String savePath="d:\\log";
	public void setSavePath(String savePath){
		this.savePath=savePath;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
							 HttpServletResponse response, 
							 Object handler)
			throws Exception {
		
		MemberVO loginUser = 
				(MemberVO)request.getSession().getAttribute("loginUser");
				
		String removeUserID=request.getParameter("id");
		MemberVO removeUser = memberService.getMemberById(removeUserID);
		
		boolean result=true;
		
		String log="[remove:user]";
		if(loginUser.getId().equals("admin00")){
			log+=removeUser.getId()+","
				+removeUser.getName()+","
				+removeUser.getEmail()+","
				+new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
			File logPath = new File(savePath);
			if(!logPath.exists()){
				logPath.mkdirs();
			}
			
			String logFileName = savePath+File.separator+"remove_user_log.txt";
			
			BufferedWriter out=
					new BufferedWriter(new FileWriter(logFileName,true));
			 out.write(log);
			 out.newLine();
			 out.close();
			 
		}else{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원삭제는 admin00계정만 가능합니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			
			result=false;
		}
		return result;
	}

	
	
}
