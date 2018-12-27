package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.LoginDataVO;

public interface LoginDataService {
	
	List<LoginDataVO> getLoginData()throws SQLException;
	void insertLog(List<LoginDataVO> logList)throws SQLException;
}
