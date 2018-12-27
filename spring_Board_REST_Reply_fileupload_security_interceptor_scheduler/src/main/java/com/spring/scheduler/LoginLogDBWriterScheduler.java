package com.spring.scheduler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.spring.dto.LoginDataVO;
import com.spring.service.LoginDataService;

public class LoginLogDBWriterScheduler {
	
	private LoginDataService logService;
	public void setLogService(LoginDataService logService){
		this.logService=logService;		
	}
	
	private String logFileName="login_user_log.txt";
	private String logSavePath="d:\\log";
	
	public void setLogFileName(String fileName){
		this.logFileName=fileName;
	}
	public void setLogSavePath(String path){
		this.logSavePath=path;
	}
	
	public void logToDBWriter() throws Exception{
		String logFile=logSavePath+File.separator+logFileName;
		File log=new File(logFile);
		if(log.exists()){
			System.out.println("log existed : "+logFile);
			
			BufferedReader in=new BufferedReader(new FileReader(log));
			String line="";
			
			List<LoginDataVO> logList=new ArrayList<LoginDataVO>();
			while((line=in.readLine())!=null){
				line=line.replace("[login:user]", "");
				String[] args=line.split(",");
				Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(args[4]);	
				
				LoginDataVO logData=new LoginDataVO();
				logData.setId(args[0]);
				logData.setName(args[1]);
				logData.setEmail(args[2]);
				logData.setIp(args[3]);
				logData.setIndate(date);
				
				logList.add(logData);
			}
			
			logService.insertLog(logList);
		}else{
			System.out.println("log not existed : "+logFile);
		}
	}
	
}












